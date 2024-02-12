package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerFileDelete extends DockerFileImageGroup {

    DockerFileDelete() {
        super()
        description = 'A task that will delete the image created by the dockerFileBuild task'
        internalCommand.convention('rm')
    }

}
