package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker dev management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerDev extends DockerTask {
    DockerDev() {
        super()
        description = 'A convenience docker dev management command.'
        internalManagement.convention('dev')
    }
}
