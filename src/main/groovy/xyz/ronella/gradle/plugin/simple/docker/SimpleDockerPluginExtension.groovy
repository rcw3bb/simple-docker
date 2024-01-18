package xyz.ronella.gradle.plugin.simple.docker

import org.gradle.api.provider.Property

/**
 * The extension for customized the behaviour of the plugin.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class SimpleDockerPluginExtension {

    /**
     * Displays more information.
     */
    abstract Property<Boolean> getVerbose()

    /**
     * The default directory to use if the directory was not specified.
     */
    abstract Property<File> getDirectory()

    /**
     * It is like verbose but don't execute the docker command.
     */
    abstract Property<Boolean> getNoop()

    SimpleDockerPluginExtension() {
        noop.convention(false)
        verbose.convention(false)
    }

    def writeln(String text) {
        if (verbose.get() || noop.get()) {
            println(text)
        }
    }

}
