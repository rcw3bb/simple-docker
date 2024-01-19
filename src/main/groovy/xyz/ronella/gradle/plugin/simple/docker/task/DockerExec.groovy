package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerExec extends DockerContainer {
    DockerExec() {
        super()
        description = 'A convenience docker exec command.'
        internalCommand.convention('exec')
    }
}
