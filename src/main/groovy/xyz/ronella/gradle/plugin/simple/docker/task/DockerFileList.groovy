package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerFileList extends DockerImage {
    DockerFileList() {
        group = 'Simple docker - Dockerfile'
        description = 'A task that will list the image created by the dockerFileBuild task'
        internalCommand.convention('list')
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
