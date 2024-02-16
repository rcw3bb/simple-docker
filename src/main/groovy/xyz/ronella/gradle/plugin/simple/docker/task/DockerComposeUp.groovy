package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker auto task for the Docker compose up command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerComposeUp extends DockerComposeGroup {

    DockerComposeUp() {
        super()
        description = 'A task for initializing and starting docker composed services'
        internalCommand.convention('up')
        args.convention(List.of('--detach'))
    }
}
