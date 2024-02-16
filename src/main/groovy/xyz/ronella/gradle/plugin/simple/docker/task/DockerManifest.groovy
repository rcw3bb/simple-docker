package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker manifest management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerManifest extends DockerTask {
    DockerManifest() {
        super()
        description = 'A convenience docker manifest management command.'
        internalManagement.convention('manifest')
    }
}
