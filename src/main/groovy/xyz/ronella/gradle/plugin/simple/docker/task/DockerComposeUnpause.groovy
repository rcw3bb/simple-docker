package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker auto task for the Docker compose unpause command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerComposeUnpause extends DockerComposeGroup {
    DockerComposeUnpause() {
        super()
        description = 'A task for unpausing docker composed services'
        internalCommand.convention('unpause')
    }
}
