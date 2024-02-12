package xyz.ronella.gradle.plugin.simple.docker.task

import xyz.ronella.gradle.plugin.simple.docker.util.IDockerFileExecute
import xyz.ronella.gradle.plugin.simple.docker.util.impl.DefaultDockerFileExecute

abstract class DockerFileImageGroup extends DockerImage {
    DockerFileImageGroup() {
        super()
        group = 'Simple docker - Dockerfile'
        internalZArgs.add(EXTENSION.dockerFile.tag.get())
    }

    final def executeCommand() {
        executor(new DefaultDockerFileExecute(EXTENSION)) {
            super.executeCommand()
        }
    }

    void executor(IDockerFileExecute execute, Closure logic) {
        execute.execute(this, logic)
    }
}
