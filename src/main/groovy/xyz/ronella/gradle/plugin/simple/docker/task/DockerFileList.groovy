package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerFileList extends DockerImage {
    DockerFileList() {
        group = 'Simple docker - Dockerfile'
        description = 'A task that will list the image created by the dockerFileBuild task'
        internalCommand.convention('list')
        internalZArgs.add(EXTENSION.dockerFileBuildTag.get())
    }
}
