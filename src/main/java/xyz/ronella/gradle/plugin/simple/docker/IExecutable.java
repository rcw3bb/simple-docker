package xyz.ronella.gradle.plugin.simple.docker;

import xyz.ronella.gradle.plugin.simple.docker.impl.LinuxOS;
import xyz.ronella.gradle.plugin.simple.docker.impl.OtherOS;
import xyz.ronella.gradle.plugin.simple.docker.impl.WindowsOS;
import xyz.ronella.gradle.plugin.simple.docker.impl.MacOS;
import xyz.ronella.trivial.handy.OSType;

/**
 * The template of identifying the actual docker executable.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
public interface IExecutable {

    /**
     * Must return the valid docker executable.
     *
     * @return The docker executable.
     */
    String getExecutable();

    /**
     * The factory of creating a valid IExecutable implementation.
     *
     * @param osType An instance of OSType
     * @return An implementation of IExecutable.
     */
    static IExecutable getInstance(final OSType osType) {
        switch (osType) {
            case Windows:
                return new WindowsOS();
            case Linux:
                return new LinuxOS();
            case Mac:
                return new MacOS();
            default:
                return new OtherOS();
        }
    }
}
