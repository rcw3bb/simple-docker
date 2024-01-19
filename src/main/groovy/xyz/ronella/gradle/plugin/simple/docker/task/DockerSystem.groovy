package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerSystem extends DockerTask {
    DockerSystem() {
        super()
        description = 'A convenience docker system management command.'
        internalManagement.convention('system')
    }
}
