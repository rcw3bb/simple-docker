package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerExtension extends DockerTask {
    DockerExtension() {
        super()
        description = 'A convenience docker extension management command.'
        internalManagement.convention('extension')
    }
}
