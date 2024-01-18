package xyz.ronella.gradle.plugin.simple.docker

import org.gradle.api.Plugin
import org.gradle.api.Project
import xyz.ronella.gradle.plugin.simple.docker.task.*

/**
 * The entry point of the plugin.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
class SimpleDockerPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create('simple_docker', SimpleDockerPluginExtension)
        project.extensions.create('simple_docker_test', SimpleDockerPluginTestExtension)
        project.task('dockerTask', type: DockerTask)
        project.task('dockerVersion', type: DockerVersion)
    }
}