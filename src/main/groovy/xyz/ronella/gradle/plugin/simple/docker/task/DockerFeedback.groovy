package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker feedback management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerFeedback extends DockerTask {
    DockerFeedback() {
        super()
        description = 'A convenience docker feedback management command.'
        internalManagement.convention('feedback')
    }
}
