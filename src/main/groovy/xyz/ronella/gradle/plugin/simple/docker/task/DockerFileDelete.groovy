package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerFileDelete extends DockerImage {

    DockerFileDelete() {
        group = 'Simple docker - Dockerfile'
        description = 'A task that will delete the image created by the dockerFileBuild task'
        internalCommand.convention('rm')
        internalZArgs.add(EXTENSION.dockerFileBuildTag.get())
    }
}
