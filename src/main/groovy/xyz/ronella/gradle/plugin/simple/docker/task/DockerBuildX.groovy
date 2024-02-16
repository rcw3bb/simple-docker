package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker buildx management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerBuildX extends DockerTask {
    DockerBuildX() {
        super()
        description = 'A convenience docker buildx management command.'
        internalManagement.convention('buildx')
    }
}
