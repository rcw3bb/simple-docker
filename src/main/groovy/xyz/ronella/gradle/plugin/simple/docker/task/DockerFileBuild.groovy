package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerFileBuild extends DockerBuildX {
    DockerFileBuild() {
        super()
        group = 'Simple docker - Dockerfile'
        description = 'A task for building the image based on Dockerfile'
        internalCommand.convention('build')
        internalArgs.addAll('--tag', EXTENSION.dockerFile.tag.get())
        internalZArgs.add('.')
    }

    def executeCommand() {
        if (EXTENSION.dockerFile.tag.get().empty) {
            System.err.println("Please set the simple_docker.dockerFile.tag property.")
            return
        }
        super.executeCommand()
    }
}
