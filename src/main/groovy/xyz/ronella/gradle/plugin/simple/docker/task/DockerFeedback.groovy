package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerFeedback extends DockerTask {
    DockerFeedback() {
        super()
        description = 'A convenience docker feedback management command.'
        internalManagement.convention('feedback')
    }
}
