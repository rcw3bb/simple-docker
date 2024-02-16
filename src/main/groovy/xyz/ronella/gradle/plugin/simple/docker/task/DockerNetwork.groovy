package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker network management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerNetwork extends DockerTask {
    DockerNetwork() {
        super()
        description = 'A convenience docker network management command.'
        internalManagement.convention('network')
    }
}
