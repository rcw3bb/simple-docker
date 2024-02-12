package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerCompose extends DockerTask {
    DockerCompose() {
        super()
        description = 'A convenience docker compose management command.'
        internalManagement.convention('compose')
    }
}
