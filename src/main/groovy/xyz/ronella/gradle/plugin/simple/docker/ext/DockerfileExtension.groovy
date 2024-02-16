package xyz.ronella.gradle.plugin.simple.docker.ext

import org.gradle.api.provider.Property

/**
 * The extension for dockerfile tasks.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerfileExtension {

    /**
     * The tag to be used with DockerTasks.
     */
    abstract Property<String> getTag()

    DockerfileExtension() {
        tag.convention('')
    }

}
