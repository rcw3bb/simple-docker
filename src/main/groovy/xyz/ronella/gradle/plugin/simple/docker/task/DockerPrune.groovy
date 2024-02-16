package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The auto docker task for the Docker prune command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerPrune extends DockerImage {
    DockerPrune() {
        super()
        description = 'A convenience task for pruning unused images'
        internalArgs.addAll('prune', '--force', '--all')
    }
}
