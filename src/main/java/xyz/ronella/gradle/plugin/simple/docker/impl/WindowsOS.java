package xyz.ronella.gradle.plugin.simple.docker.impl;

import xyz.ronella.gradle.plugin.simple.docker.IExecutable;
import xyz.ronella.gradle.plugin.simple.docker.IScript;

/**
 * An implementation specific to Windows.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
public class WindowsOS implements IExecutable, IScript {

    @Override
    public String getExecutable() {
        return "docker.exe";
    }

    @Override
    public String getScript() {
        return "execute-docker.bat";
    }
}
