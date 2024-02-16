package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker container management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerContainer extends DockerTask {
    DockerContainer() {
        super()
        description = 'A convenience docker container management command.'
        internalManagement.convention('container')
    }
}
