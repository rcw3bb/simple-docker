package xyz.ronella.gradle.plugin.simple.docker.util

interface IDockerFileExecutable {
    void executor(IDockerFileExecute execute, Closure logic)
}
