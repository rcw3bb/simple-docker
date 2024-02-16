package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker extension management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerExtension extends DockerTask {
    DockerExtension() {
        super()
        description = 'A convenience docker extension management command.'
        internalManagement.convention('extension')
    }
}
