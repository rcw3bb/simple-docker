package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker auto task for the Dockerfile delete command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerFileDelete extends DockerFileImageGroup {

    DockerFileDelete() {
        super()
        description = 'A task that will delete the image created by the dockerFileBuild task'
        internalCommand.convention('rm')
    }

}
