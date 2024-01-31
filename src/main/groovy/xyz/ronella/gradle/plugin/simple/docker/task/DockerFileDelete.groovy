package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerFileDelete extends DockerImage {

    DockerFileDelete() {
        group = 'Simple docker - Dockerfile'
        description = 'A task that will delete the image created by the dockerFileBuild task'
        internalCommand.convention('rm')
        internalZArgs.add(EXTENSION.dockerFile.tag.get())
    }

    def executeCommand() {
        if (EXTENSION.dockerFile.tag.get().empty) {
            System.err.println("Please set the simple_docker.dockerFile.tag property.")
            return
        }
        super.executeCommand()
    }
}
