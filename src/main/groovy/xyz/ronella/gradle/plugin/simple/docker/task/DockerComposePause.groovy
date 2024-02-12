package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerComposePause extends DockerComposeGroup {

    DockerComposePause() {
        super()
        description = 'A task for pausing docker composed services'
        internalCommand.convention('pause')
    }
}
