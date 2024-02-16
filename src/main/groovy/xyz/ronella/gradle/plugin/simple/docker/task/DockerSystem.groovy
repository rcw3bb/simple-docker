package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker system management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerSystem extends DockerTask {
    DockerSystem() {
        super()
        description = 'A convenience docker system management command.'
        internalManagement.convention('system')
    }
}
