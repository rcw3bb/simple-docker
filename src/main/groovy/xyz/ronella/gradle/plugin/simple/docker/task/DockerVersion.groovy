package xyz.ronella.gradle.plugin.simple.docker.task

/**
 * A convenience docker task for knowing the docker version.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
abstract class DockerVersion extends DockerTask {
    DockerVersion() {
        super()
        description = 'A convenience docker --version command.'
        args.add('--version')
        forceDirectory.convention(false)
    }
}
