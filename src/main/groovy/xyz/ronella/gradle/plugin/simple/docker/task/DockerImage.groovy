package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker image management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerImage extends DockerTask {
    DockerImage() {
        super()
        description = 'A convenience docker image management command.'
        internalManagement.convention('image')
    }
}
