package xyz.ronella.gradle.plugin.simple.docker.ext

import org.gradle.api.provider.Property

abstract class DockerfileExtension {

    abstract Property<String> getTag()

    DockerfileExtension() {
        tag.convention('')
    }

}
