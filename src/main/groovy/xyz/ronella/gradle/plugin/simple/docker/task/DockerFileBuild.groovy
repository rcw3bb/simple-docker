package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerFileBuild extends DockerBuildX {
    DockerFileBuild() {
        super()
        group = 'Simple docker - Dockerfile'
        description = 'A task for building the image based on Dockerfile.'
        internalCommand.convention('build')
        internalArgs.addAll('--tag', EXTENSION.dockerFileBuildTag.get())
        internalZArgs.add('.')
    }

    def executeCommand() {
        if (EXTENSION.dockerFileBuildTag.get().empty) {
            System.err.println("Please set the simple_docker.dockerFileBuildTag property.")
            return
        }
        super.executeCommand()
    }
}
