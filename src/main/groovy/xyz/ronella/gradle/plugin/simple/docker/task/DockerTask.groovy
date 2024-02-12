package xyz.ronella.gradle.plugin.simple.docker.task

import org.gradle.api.DefaultTask
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction

import xyz.ronella.gradle.plugin.simple.docker.ext.SimpleDockerPluginExtension
import xyz.ronella.gradle.plugin.simple.docker.DockerExecutor
import xyz.ronella.gradle.plugin.simple.docker.ext.SimpleDockerPluginTestExtension
import xyz.ronella.trivial.handy.CommandLocator
import xyz.ronella.trivial.handy.OSType

import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Stream

/**
 * The docker task that can execute any docker command that you can do in console.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerTask extends DefaultTask {

    protected Property<String> internalCommand
    protected Property<String> internalManagement
    protected ListProperty<String> internalArgs
    protected ListProperty<String> internalZArgs

    /**
     * Force the execute the docker command inside a directory.
     */
    @Optional @Input
    abstract Property<Boolean> getForceDirectory()

    /**
     * The options added before the docker command.
     */
    @Optional @Input
    abstract ListProperty<String> getOptions()

    protected final OSType OS_TYPE
    protected final SimpleDockerPluginExtension EXTENSION

    @Input @Optional
    abstract Property<File> getDirectory()

    /**
     * The docker command to execute.
     */
    @Input @Optional
    abstract Property<String> getCommand()

    @Input @Optional
    abstract Property<String> getManagement()

    /**
     * The arguments for the docker command.
     */
    @Input
    abstract ListProperty<String> getArgs()

    @Optional @Input
    abstract ListProperty<String> getZargs()

    DockerTask() {
        group = 'Simple docker'
        description = 'Execute a docker command.'
        OS_TYPE = DockerExecutor.OS_TYPE
        EXTENSION = project.extensions.simple_docker
        forceDirectory.convention(true)
        directory.convention(project.rootProject.rootDir)

        var objects = project.objects
        internalCommand = objects.property(String)
        internalManagement = objects.property(String)
        internalArgs = objects.listProperty(String)
        internalZArgs = objects.listProperty(String)
    }

    /**
     * Assemble all the arguments for the docker command.
     *
     * @return An array of arguments for the docker command.
     */
    @Internal
    protected ListProperty<String> getAllArgs() {

        def newArgs = []
        newArgs.addAll(internalArgs.get())
        newArgs.addAll(args.get())
        newArgs.addAll(internalZArgs.get())
        newArgs.addAll(zargs.get())

        def allTheArgs = project.getObjects().listProperty(String.class)

        if (internalCommand.getOrElse("").length() > 0 || command.getOrElse("").length()>0 || newArgs.size() > 0) {
            allTheArgs.addAll(newArgs)
        }
        else {
            allTheArgs.add('--help')
        }

        return allTheArgs
    }

    /**
     * Build and instance of dockerExecutor.
     *
     * @return An instance of dockerExecutor.
     */
    @Internal
    DockerExecutor getExecutor() {
        def knownDocker = CommandLocator.locateAsString(DockerExecutor.EXECUTABLE).orElse(null)
        def builder = DockerExecutor.getBuilder()

        builder.addKnownDockerExe(knownDocker)
        builder.addManagementCommand(internalManagement.getOrElse(management.orNull))
        builder.addCommand(internalCommand.getOrElse(command.orNull))
        builder.addArgs(allArgs.getOrElse([]))
        builder.addOpts(options.getOrElse([]))
        builder.addForceDirectory(forceDirectory.get())

        def  targetDir = java.util.Optional.ofNullable(directory.get())

        if (directory.get()==project.rootProject.rootDir) {
            targetDir = java.util.Optional.ofNullable(EXTENSION.directory.getOrElse(directory.get()))
        }

        targetDir.ifPresent { ___dir->
            builder.addDirectory(___dir)
        }

        return builder.build()
    }

    boolean directoryIsEmpty() {
        if (directory.isPresent()) {
            def dirFile = directory.get()
            if (dirFile.exists()) {
                try (Stream<Path> entries = Files.list(dirFile.toPath())) {
                    def hasEntry = entries.findFirst().isPresent()
                    if (hasEntry) {
                        println("${dirFile.absolutePath} is not empty.")
                    }
                    return !hasEntry
                }
            }
        }

        return true
    }

    /**
     * The main action logic of the task.
     */
    @TaskAction
    def executeCommand() {
        SimpleDockerPluginTestExtension pluginTestExt = project.extensions.simple_docker_test;

        def executor = getExecutor()
        executor.execute { context ->
            def dockerExecutable = pluginTestExt.no_docker_installed ? null : context.dockerExe

            if (dockerExecutable!=null) {
                String[] fullCommand = [context.command]
                Path scriptFile = context.script
                EXTENSION.writeln("Script: " + scriptFile.toString())
                EXTENSION.writeln("OS: ${DockerExecutor.OS_TYPE}")
                EXTENSION.writeln("Command to execute: ${fullCommand.join(' ')}")

                if (!EXTENSION.noop.get()) {
                    project.exec {
                        executable context.executable
                        if (context.execArgs) {
                            args context.execArgs.toArray()
                        }
                    }
                } else {
                    EXTENSION.writeln("No-operation is activated.")
                }
            }
            else {
                String message = "${DockerExecutor.EXECUTABLE} not found. Please install docker application and try again."
                pluginTestExt.test_message = message
                println(message)
            }
        }
    }
}
