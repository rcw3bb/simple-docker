package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The base class for all the auto docker compose tasks.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerComposeGroup extends DockerCompose {
    DockerComposeGroup() {
        super()
        group = 'Simple docker - Compose'
    }
}
