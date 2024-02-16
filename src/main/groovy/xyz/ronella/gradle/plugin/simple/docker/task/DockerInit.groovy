package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker init management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerInit extends DockerTask {
    DockerInit() {
        super()
        description = 'A convenience docker init management command.'
        internalManagement.convention('init')
    }
}
