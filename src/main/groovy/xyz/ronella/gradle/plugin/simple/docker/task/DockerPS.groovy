package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerPS extends DockerContainer {
    DockerPS() {
        super()
        description = 'A convenience docker --version command.'
        internalCommand.convention('ps')
        args.convention(['-a'])
    }
}
