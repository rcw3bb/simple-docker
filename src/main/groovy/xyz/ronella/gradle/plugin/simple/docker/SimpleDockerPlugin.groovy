package xyz.ronella.gradle.plugin.simple.docker

import org.gradle.api.Plugin
import org.gradle.api.Project
import xyz.ronella.gradle.plugin.simple.docker.task.*

import java.nio.file.Paths

/**
 * The entry point of the plugin.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
class SimpleDockerPlugin implements Plugin<Project> {

    private static final String DOCKER_FILE = "Dockerfile"

    @Override
    void apply(Project project) {

        final def dockerFile = Paths.get(project.rootProject.rootDir.absolutePath, DOCKER_FILE).toFile()

        project.extensions.create('simple_docker', SimpleDockerPluginExtension)
        project.extensions.create('simple_docker_test', SimpleDockerPluginTestExtension)

        project.task('dockerListImages', type: DockerListImages)
        project.task('dockerVersion', type: DockerVersion)
        project.task('dockerPrune', type: DockerPrune)

        if (dockerFile.exists()) {
            project.tasks.register('dockerFileBuild', DockerFileBuild.class)
            project.tasks.register('dockerFileDelete', DockerFileDelete.class)
            project.tasks.register('dockerFileList', DockerFileList.class)
        }
    }
}