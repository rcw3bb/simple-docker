package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerComposeStart extends DockerComposeGroup {
    DockerComposeStart() {
        super()
        description = 'A task for starting docker composed services'
        internalCommand.convention('start')
    }
}
