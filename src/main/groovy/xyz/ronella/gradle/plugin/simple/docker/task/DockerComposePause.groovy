package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker auto task for the Docker compose pause command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerComposePause extends DockerComposeGroup {

    DockerComposePause() {
        super()
        description = 'A task for pausing docker composed services'
        internalCommand.convention('pause')
    }
}
