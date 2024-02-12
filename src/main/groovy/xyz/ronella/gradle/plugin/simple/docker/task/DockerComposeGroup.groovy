package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerComposeGroup extends DockerCompose {

    DockerComposeGroup() {
        super()
        group = 'Simple docker - Compose'
    }
}
