package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerManifest extends DockerTask {
    DockerManifest() {
        super()
        description = 'A convenience docker manifest management command.'
        internalManagement.convention('manifest')
    }
}
