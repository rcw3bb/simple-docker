package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerPlugin extends DockerTask {
    DockerPlugin() {
        super()
        description = 'A convenience docker plugin management command.'
        internalManagement.convention('plugin')
    }
}
