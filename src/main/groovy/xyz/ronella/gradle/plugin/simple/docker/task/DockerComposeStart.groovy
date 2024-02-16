package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker auto task for the Docker compose start command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerComposeStart extends DockerComposeGroup {
    DockerComposeStart() {
        super()
        description = 'A task for starting docker composed services'
        internalCommand.convention('start')
    }
}
