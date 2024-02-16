package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker compose management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerCompose extends DockerTask {
    DockerCompose() {
        super()
        description = 'A convenience docker compose management command.'
        internalManagement.convention('compose')
    }
}
