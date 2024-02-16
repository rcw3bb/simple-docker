package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker auto task for the Docker compose down command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerComposeDown extends DockerComposeGroup {
    DockerComposeDown() {
        super()
        description = 'A task for removing containers of docker composed services'
        internalCommand.convention('down')
    }
}
