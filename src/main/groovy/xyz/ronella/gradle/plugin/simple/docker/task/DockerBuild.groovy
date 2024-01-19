package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerBuild extends DockerBuildX {
    DockerBuild() {
        super()
        description = 'A convenience docker build command.'
        internalCommand.convention('build')
    }
}
