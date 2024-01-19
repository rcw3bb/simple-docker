package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerContainer extends DockerTask {
    DockerContainer() {
        super()
        description = 'A convenience docker container management command.'
        internalManagement.convention('container')
    }
}
