package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker auto task for the Docker compose stop command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerComposeStop extends DockerComposeGroup {
    DockerComposeStop() {
        super()
        description = 'A task for stopping docker composed services'
        internalCommand.convention('stop')
    }

}
