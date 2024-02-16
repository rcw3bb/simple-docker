package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker volume management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerVolume extends DockerTask {
    DockerVolume() {
        super()
        description = 'A convenience docker volume management command.'
        internalManagement.convention('volume')
    }
}
