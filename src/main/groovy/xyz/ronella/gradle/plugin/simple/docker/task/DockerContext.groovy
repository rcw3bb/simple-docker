package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The docker task for the Docker context management command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerContext extends DockerTask {
    DockerContext() {
        super()
        description = 'A convenience docker context management command.'
        internalManagement.convention('context')
    }
}
