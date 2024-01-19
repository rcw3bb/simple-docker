package xyz.ronella.gradle.plugin.simple.docker

import org.gradle.api.Plugin
import org.gradle.api.Project
import xyz.ronella.gradle.plugin.simple.docker.task.*
import xyz.ronella.trivial.handy.CommandLocator

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

        CommandLocator.locateAsString(DockerExecutor.EXECUTABLE).ifPresentOrElse(___ -> {
            project.task('dockerBuild', type:DockerBuild)
            project.task('dockerContainer', type:DockerContainer)
            project.task('dockerExec', type:DockerExec)
            project.task('dockerRun', type: DockerRun)
            project.task('dockerPS', type: DockerPS)
            project.task('dockerTask', type: DockerTask)
            project.task('dockerVersion', type: DockerVersion)
        }, () -> {
            project.task('dockerNotFound', type: DockerNotFound)
        })
    }
}