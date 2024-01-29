package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerComposeUp extends DockerCompose {

    DockerComposeUp() {
        super()
        description = 'A task for initializing and starting docker composed services'
        internalCommand.convention('up')
        args.convention(List.of('--detach'))
    }
}
