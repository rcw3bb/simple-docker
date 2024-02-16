package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker scout management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerScout extends DockerTask {
    DockerScout() {
        super()
        description = 'A convenience docker scout management command.'
        internalManagement.convention('scout')
    }
}
