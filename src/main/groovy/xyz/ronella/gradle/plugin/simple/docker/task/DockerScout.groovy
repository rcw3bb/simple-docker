package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerScout extends DockerTask {
    DockerScout() {
        super()
        description = 'A convenience docker scout management command.'
        internalManagement.convention('scout')
    }
}
