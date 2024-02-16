package xyz.ronella.gradle.plugin.simple.docker.impl;

import xyz.ronella.gradle.plugin.simple.docker.IExecutable;

/**
 * An implementation specific to Linux.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
public class LinuxOS implements IExecutable {
    @Override
    public String getExecutable() {
        return "docker";
    }

    @Override
    public String getScript() {
        return "execute-docker.sh";
    }
}
