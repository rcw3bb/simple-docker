package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerVolume extends DockerTask {
    DockerVolume() {
        super()
        description = 'A convenience docker volume management command.'
        internalManagement.convention('volume')
    }
}
