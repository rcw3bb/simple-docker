package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker builder management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerBuilder extends DockerTask {
    DockerBuilder() {
        super()
        description = 'A convenience docker builder management command.'
        internalManagement.convention('builder')
    }
}
