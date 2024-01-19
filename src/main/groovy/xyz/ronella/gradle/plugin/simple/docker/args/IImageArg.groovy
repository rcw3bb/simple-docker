package xyz.ronella.gradle.plugin.simple.docker.args

import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional

/**
 * The interface to add the image argument for the command.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
interface IImageArg {
    /**
     * Must hold the name of the docker image.
     *
     * @return The docker image.
     */
    @Optional @Input
    Property<String> getImage()
}
