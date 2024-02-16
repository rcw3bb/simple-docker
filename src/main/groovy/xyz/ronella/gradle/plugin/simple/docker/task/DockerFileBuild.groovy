package xyz.ronella.gradle.plugin.simple.docker.task

import xyz.ronella.gradle.plugin.simple.docker.util.IDockerFileExecutable
import xyz.ronella.gradle.plugin.simple.docker.util.IDockerFileExecute
import xyz.ronella.gradle.plugin.simple.docker.util.impl.DefaultDockerFileExecute

/**
 * The docker auto task for the Dockerfile build command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerFileBuild extends DockerBuildX implements IDockerFileExecutable {
    DockerFileBuild() {
        super()
        group = 'Simple docker - Dockerfile'
        description = 'A task for building the image based on Dockerfile'
        internalCommand.convention('build')
        internalArgs.addAll('--tag', EXTENSION.dockerFile.tag.get())
        internalZArgs.add('.')
    }

    final def executeCommand() {
        executor(new DefaultDockerFileExecute(EXTENSION)) {
            super.executeCommand()
        }
    }

    void executor(IDockerFileExecute execute, Closure logic) {
        execute.execute(this, logic)
    }
}
