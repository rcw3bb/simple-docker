package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerBuilder extends DockerTask {
    DockerBuilder() {
        super()
        description = 'A convenience docker builder management command.'
        internalManagement.convention('builder')
    }
}
