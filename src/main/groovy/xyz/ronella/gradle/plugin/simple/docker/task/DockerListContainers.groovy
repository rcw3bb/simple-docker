package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerListContainers extends DockerContainer {
    DockerListContainers() {
        super()
        description = 'A convenience task for listing the containers'
        internalArgs.convention(List.of('ls', '--all'))
    }
}
