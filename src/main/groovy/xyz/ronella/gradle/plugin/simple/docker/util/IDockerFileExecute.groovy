package xyz.ronella.gradle.plugin.simple.docker.util

import xyz.ronella.gradle.plugin.simple.docker.task.DockerBuildX
import xyz.ronella.gradle.plugin.simple.docker.task.DockerImage

/**
 * The interface that holds all the execute signature that must be implemented
 *
 * @author Ron Webb
 * @since 1.0.0
 */
interface IDockerFileExecute {

    /**
     * Must hold the execute implementation for DockerBuildX instance.
     * @param build The DockerBuildX instance.
     * @param logic The logic to be associated with the execute logic.
     */
    void execute(DockerBuildX build, Closure logic)

    /**
     * Must hold the execute implementation for DockerImage instance.
     * @param build The DockerImage instance.
     * @param logic The logic to be associated with the execute logic.
     */
    void execute(DockerImage image, Closure logic)
}