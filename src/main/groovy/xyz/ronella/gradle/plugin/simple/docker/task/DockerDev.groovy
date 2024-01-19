package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerDev extends DockerTask {
    DockerDev() {
        super()
        description = 'A convenience docker dev management command.'
        internalManagement.convention('dev')
    }
}
