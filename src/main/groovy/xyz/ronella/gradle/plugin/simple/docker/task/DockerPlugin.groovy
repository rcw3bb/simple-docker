package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker plugin management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerPlugin extends DockerTask {
    DockerPlugin() {
        super()
        description = 'A convenience docker plugin management command.'
        internalManagement.convention('plugin')
    }
}
