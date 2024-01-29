package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerCompose extends DockerTask {
    DockerCompose() {
        super()
        group = 'Simple docker - Compose'
        description = 'A convenience docker compose management command.'
        internalManagement.convention('compose')
    }
}
