package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker auto task for the Docker compose restart command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerComposeRestart extends DockerComposeGroup {
    DockerComposeRestart() {
        super()
        description = 'A task for restarting docker composed services'
        internalCommand.convention('restart')
    }
}
