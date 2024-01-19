package xyz.ronella.gradle.plugin.simple.docker.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * The only noop task available if no docker binary is found.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerNotFound extends DefaultTask {

    DockerNotFound() {
        group = 'Simple docker'
        description = 'No docker binary found.'
    }

    @TaskAction
    def executeCommand() {
        System.err.println("No docker binary found.")
    }
}
