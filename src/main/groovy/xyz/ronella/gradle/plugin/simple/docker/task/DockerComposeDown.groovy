package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerComposeDown extends DockerComposeGroup {
    DockerComposeDown() {
        super()
        description = 'A task for removing containers of docker composed services'
        internalCommand.convention('down')
    }
}
