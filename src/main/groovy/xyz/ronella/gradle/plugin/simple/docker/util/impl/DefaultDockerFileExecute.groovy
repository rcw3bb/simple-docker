package xyz.ronella.gradle.plugin.simple.docker.util.impl

import xyz.ronella.gradle.plugin.simple.docker.ext.SimpleDockerPluginExtension
import xyz.ronella.gradle.plugin.simple.docker.task.DockerBuildX
import xyz.ronella.gradle.plugin.simple.docker.task.DockerImage
import xyz.ronella.gradle.plugin.simple.docker.util.IDockerFileExecute

class DefaultDockerFileExecute implements IDockerFileExecute {
    final SimpleDockerPluginExtension ext

    DefaultDockerFileExecute(SimpleDockerPluginExtension ext) {
        this.ext = ext
    }

    private void checkDockerFileTag(Closure logic) {
        if (ext.dockerFile.tag.get().empty) {
            System.err.println("Please set the simple_docker.dockerFile.tag property.")
            return
        }
        logic()
    }

    @Override
    void execute(DockerBuildX build, Closure logic) {
        checkDockerFileTag(logic)
    }

    @Override
    void execute(DockerImage image, Closure logic) {
        checkDockerFileTag(logic)
    }
}
