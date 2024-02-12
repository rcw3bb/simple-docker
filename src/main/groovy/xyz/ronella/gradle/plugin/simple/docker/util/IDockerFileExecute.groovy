package xyz.ronella.gradle.plugin.simple.docker.util

import xyz.ronella.gradle.plugin.simple.docker.task.DockerBuildX
import xyz.ronella.gradle.plugin.simple.docker.task.DockerImage

interface IDockerFileExecute {
    void execute(DockerBuildX build, Closure logic)
    void execute(DockerImage image, Closure logic)
}