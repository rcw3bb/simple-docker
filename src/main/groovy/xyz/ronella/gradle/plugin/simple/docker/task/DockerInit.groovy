package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerInit extends DockerTask {
    DockerInit() {
        super()
        description = 'A convenience docker init management command.'
        internalManagement.convention('init')
    }
}
