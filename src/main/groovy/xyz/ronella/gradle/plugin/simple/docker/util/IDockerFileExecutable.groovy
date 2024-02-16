package xyz.ronella.gradle.plugin.simple.docker.util

/**
 * The interface to implement to be able to accept an implementation of IDockerFileExecute.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
interface IDockerFileExecutable {
    void executor(IDockerFileExecute execute, Closure logic)
}
