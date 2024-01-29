package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerComposeStart extends DockerCompose {
    DockerComposeStart() {
        super()
        description = 'A task for starting docker composed services'
        internalCommand.convention('start')
    }
}
