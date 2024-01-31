package xyz.ronella.gradle.plugin.simple.docker

import org.gradle.api.Plugin
import org.gradle.api.Project
import xyz.ronella.gradle.plugin.simple.docker.ext.DockerfileExtension
import xyz.ronella.gradle.plugin.simple.docker.ext.SimpleDockerPluginExtension
import xyz.ronella.gradle.plugin.simple.docker.ext.SimpleDockerPluginTestExtension
import xyz.ronella.gradle.plugin.simple.docker.task.*

import java.nio.file.Paths

/**
 * The entry point of the plugin.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
class SimpleDockerPlugin implements Plugin<Project> {

    private static final String DOCKER_FILE = 'Dockerfile'
    private static final String DOCKER_COMPOSE_FILE = 'docker-compose.yml'

    @Override
    void apply(Project project) {

        final def rootDir = project.rootProject.rootDir.absolutePath
        final def dockerFile = Paths.get(rootDir, DOCKER_FILE).toFile()
        final def dockerComposeFile= Paths.get(rootDir, DOCKER_COMPOSE_FILE).toFile()

        project.extensions.create('simple_docker', SimpleDockerPluginExtension)
        project.simple_docker.extensions.create('dockerFile', DockerfileExtension)
        project.extensions.create('simple_docker_test', SimpleDockerPluginTestExtension)

        project.task('dockerListContainers', type: DockerListContainers)
        project.task('dockerListImages', type: DockerListImages)
        project.task('dockerVersion', type: DockerVersion)
        project.task('dockerPrune', type: DockerPrune)

        if (dockerComposeFile.exists()) {
            project.tasks.register('dockerComposeDown', DockerComposeDown.class)
            project.tasks.register('dockerComposePause', DockerComposePause.class)
            project.tasks.register('dockerComposeRestart', DockerComposeRestart.class)
            project.tasks.register('dockerComposeStart', DockerComposeStart.class)
            project.tasks.register('dockerComposeStop', DockerComposeStop.class)
            project.tasks.register('dockerComposeUnpause', DockerComposeUnpause.class)
            project.tasks.register('dockerComposeUp', DockerComposeUp.class)
        }

        if (dockerFile.exists()) {
            project.tasks.register('dockerFileBuild', DockerFileBuild.class)
            project.tasks.register('dockerFileDelete', DockerFileDelete.class)
            project.tasks.register('dockerFileList', DockerFileList.class)
        }
    }
}