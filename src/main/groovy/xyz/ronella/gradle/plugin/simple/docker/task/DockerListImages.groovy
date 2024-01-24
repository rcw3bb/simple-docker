package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerListImages extends DockerImage {

    DockerListImages() {
        super()
        description = 'A convenience task for listing the images'
        internalArgs.add('ls')
    }

}
