package xyz.ronella.gradle.plugin.simple.docker;

import xyz.ronella.gradle.plugin.simple.docker.impl.LinuxOS;
import xyz.ronella.gradle.plugin.simple.docker.impl.MacOS;
import xyz.ronella.gradle.plugin.simple.docker.impl.OtherOS;
import xyz.ronella.gradle.plugin.simple.docker.impl.WindowsOS;
import xyz.ronella.trivial.handy.OSType;

/**
 * The template of identifying the support script to run the docker command in a particular directory.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
public interface IScript {

    /**
     * Must give the valid support script.
     *
     * @return The support script.
     */
    String getScript();

    /**
     * The factory of creating a valid IScript implementation.
     *
     * @param osType An instance of OSType
     * @return An implementation of IExecutable.
     */
    static IScript getInstance(final OSType osType) {
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
