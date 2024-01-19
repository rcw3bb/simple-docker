package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerScan extends DockerTask {
    DockerScan() {
        super()
        description = 'A convenience docker scan management command.'
        internalManagement.convention('scan')
    }
}
