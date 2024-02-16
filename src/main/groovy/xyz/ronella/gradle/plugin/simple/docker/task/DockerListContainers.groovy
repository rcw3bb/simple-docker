package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The auto docker task for the Docker listing the containers.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerListContainers extends DockerContainer {
    DockerListContainers() {
        super()
        description = 'A convenience task for listing the containers'
        internalArgs.convention(List.of('ls', '--all'))
    }
}
