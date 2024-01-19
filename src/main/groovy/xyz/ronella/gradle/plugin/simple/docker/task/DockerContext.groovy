package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerContext extends DockerTask {
    DockerContext() {
        super()
        description = 'A convenience docker context management command.'
        internalManagement.convention('context')
    }
}
