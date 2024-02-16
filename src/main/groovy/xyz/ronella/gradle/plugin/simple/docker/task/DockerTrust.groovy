package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker trust management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerTrust extends DockerTask {
    DockerTrust() {
        super()
        description = 'A convenience docker trust management command.'
        internalManagement.convention('trust')
    }
}
