package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * The auto docker task for the Docker listing the images.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerListImages extends DockerImage {

    DockerListImages() {
        super()
        description = 'A convenience task for listing the images'
        internalArgs.convention(List.of('ls', '--all'))
    }

}
