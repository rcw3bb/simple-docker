package xyz.ronella.gradle.plugin.simple.docker.task

abstract class DockerPrune extends DockerImage{
    DockerPrune() {
        super()
        description = 'A convenience task for pruning unused images'
        internalArgs.addAll('prune', '--force', '--all')
    }
}
