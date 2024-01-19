package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerSBOM extends DockerTask {
    DockerSBOM() {
        super()
        description = 'A convenience docker sbom management command.'
        internalManagement.convention('sbom')
    }
}
