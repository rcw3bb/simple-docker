package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerNetwork extends DockerTask {
    DockerNetwork() {
        super()
        description = 'A convenience docker network management command.'
        internalManagement.convention('network')
    }
}
