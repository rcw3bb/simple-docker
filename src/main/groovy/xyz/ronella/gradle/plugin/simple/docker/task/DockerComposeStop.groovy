package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerComposeStop extends DockerCompose {
    DockerComposeStop() {
        super()
        description = 'A task for stopping docker composed services'
        internalCommand.convention('stop')
    }

}
