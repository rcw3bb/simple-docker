package xyz.ronella.gradle.plugin.simple.docker

/**
 * The extension for customized the behaviour of the plugin for testing.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
class SimpleDockerPluginTestExtension {

    /**
     * Test if no docker is installed.
     */
    public boolean no_docker_installed

    /**
     * Holds any test message.
     */
    public String test_message

}
