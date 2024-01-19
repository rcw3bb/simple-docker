package xyz.ronella.gradle.plugin.simple.docker.task

import xyz.ronella.gradle.plugin.simple.docker.args.IImageArg

abstract class DockerRun extends DockerContainer implements IImageArg {
    DockerRun() {
        super()
        description = 'A convenience docker run command.'
        internalCommand.convention('run')
    }
}
