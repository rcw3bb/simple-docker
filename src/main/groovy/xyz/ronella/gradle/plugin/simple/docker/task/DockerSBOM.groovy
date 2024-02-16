package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker sbom management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerSBOM extends DockerTask {
    DockerSBOM() {
        super()
        description = 'A convenience docker sbom management command.'
        internalManagement.convention('sbom')
    }
}
