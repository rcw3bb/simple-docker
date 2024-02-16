package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker auto task for the Dockerfile list command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerFileList extends DockerFileImageGroup {
    DockerFileList() {
        super()
        description = 'A task that will list the image created by the dockerFileBuild task'
        internalCommand.convention('list')
    }
}
