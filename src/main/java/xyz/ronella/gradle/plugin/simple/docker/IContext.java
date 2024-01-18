package xyz.ronella.gradle.plugin.simple.docker;

import java.nio.file.Path;
import java.util.List;

/**
 * The context provided in the execute method of the GitExecutor class.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
public interface IContext {
    String getCommand();
    String getDockerExe();
    List<String> getArgs();
    List<String> getOpts();
    Path getScript();
    Path getDirectory();
    String getExecutable();
    List<String> getExecArgs();
}
