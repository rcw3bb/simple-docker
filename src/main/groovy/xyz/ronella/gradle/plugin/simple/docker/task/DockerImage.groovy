package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerImage extends DockerTask {
    DockerImage() {
        super()
        description = 'A convenience docker image management command.'
        internalManagement.convention('image')
    }
}
