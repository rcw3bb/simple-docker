package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerComposeUnpause extends DockerCompose {
    DockerComposeUnpause() {
        super()
        description = 'A task for unpausing docker composed services'
        internalCommand.convention('unpause')
    }
}
