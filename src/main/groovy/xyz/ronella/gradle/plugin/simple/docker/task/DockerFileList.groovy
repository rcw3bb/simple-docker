package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerFileList extends DockerFileImageGroup {
    DockerFileList() {
        super()
        description = 'A task that will list the image created by the dockerFileBuild task'
        internalCommand.convention('list')
    }
}
