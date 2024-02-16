package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker scan management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerScan extends DockerTask {
    DockerScan() {
        super()
        description = 'A convenience docker scan management command.'
        internalManagement.convention('scan')
    }
}
