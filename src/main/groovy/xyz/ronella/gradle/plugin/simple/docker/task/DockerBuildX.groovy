package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerBuildX extends DockerTask {
    DockerBuildX() {
        super()
        description = 'A convenience docker buildx management command.'
        internalManagement.convention('buildx')
    }
}
