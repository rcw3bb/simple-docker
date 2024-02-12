package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerComposeRestart extends DockerComposeGroup {
    DockerComposeRestart() {
        super()
        description = 'A task for restarting docker composed services'
        internalCommand.convention('restart')
    }
}
