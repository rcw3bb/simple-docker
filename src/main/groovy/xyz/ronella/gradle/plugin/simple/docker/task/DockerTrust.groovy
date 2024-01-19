package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerTrust extends DockerTask {
    DockerTrust() {
        super()
        description = 'A convenience docker trust management command.'
        internalManagement.convention('trust')
    }
}
