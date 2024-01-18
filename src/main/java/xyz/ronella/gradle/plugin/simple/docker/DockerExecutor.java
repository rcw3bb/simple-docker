package xyz.ronella.gradle.plugin.simple.docker;

import xyz.ronella.trivial.handy.OSType;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * The actual assembler of the docker command to execute.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
public class DockerExecutor {

    /**
     * Holds the OS Type
     */
    public final static OSType OS_TYPE = OSType.identify();

    /**
     * Holds the docker executable.
     */
    public final static String EXECUTABLE = IExecutable.getInstance(OS_TYPE).getExecutable();

    private final List<String> args;

    private final List<String> opts;

    private final String knownExecutable;

    private final boolean forceDirectory;

    private final Path directory;

    private DockerExecutor(final ExecutorBuilder builder) {
        this.args = builder.args;
        this.opts = builder.opts;
        this.knownExecutable = builder.knownExecutable;
        this.forceDirectory = builder.forceDirectory;
        this.directory = builder.directory;
    }

    private String getProgramFile(final Path programFile) {
        if (programFile.toFile().exists())  {
            return programFile.toString();
        }
        return null;
    }

    /**
     * A utility for quoting a string.
     *
     * @param text The text to quote.
     * @return A quoted string.
     */
    public static String quoteString(final String text) {
        return quoteString(text, null);
    }

    /**
     * A utility for quoting a string based on os type.
     * Thus the return value is not necessary a quoted text.
     *
     * @param text The text to quote.
     * @param osType The os type.
     * @return A quoted string.
     */
    public static String quoteString(final String text, final OSType osType) {
        if (text==null) {
            return null;
        }
        else {
            if (osType==null || OSType.Windows==osType) {
                return String.format("\"%s\"", text);
            }
        }
        return text;
    }

    private String getKnownExecutable() {
        if (knownExecutable !=null) {
            return getProgramFile(Paths.get(knownExecutable));
        }
        return null;
    }

    private String getExecutableByEnvVar() {
        var dockerHome= Optional.ofNullable(System.getenv("DOCKER_HOME"));
        if (dockerHome.isPresent()) {
            Path programFile = Paths.get(dockerHome.get(), EXECUTABLE);
            return getProgramFile(programFile);
        }
        return null;
    }

    /**
     * Provides the docker executable.
     *
     * @return The docker executable.
     */
    public String getDockerExe() {
        List<Supplier<String>> finder = Arrays.asList(
            this::getExecutableByEnvVar,
            this::getKnownExecutable
        );

        String command = null;

        for (Supplier<String> resolver : finder) {
            command = resolver.get();
            if (null!=command) {
                break;
            }
        }

        return command==null ? null : quoteString(command, OS_TYPE);
    }

    private void makeExecutable(String script) {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("chmod", "775", script);
        try {
            Process process = builder.start();
            int exitCode = process.waitFor();
            assert exitCode ==0;
        } catch (Exception exp) {
            throw new RuntimeException(exp);
        }
    }

    private Path getScriptPath(String script) {
        final String DEFAULT_JOIN_DELIMITER = "/";
        final String SCRIPTS_DIR = "scripts";
        final Path SCRIPT_LOCATION = Paths.get("build", "simple", "docker");

        String internalScript = String.join(DEFAULT_JOIN_DELIMITER, SCRIPTS_DIR, script);
        Path pathScript = Paths.get(".", SCRIPT_LOCATION.toString(), SCRIPTS_DIR).toAbsolutePath();
        File fileScript = pathScript.toFile();
        Path outputScript = Paths.get(fileScript.toString(), script);

        if (!outputScript.toFile().exists()) {
            fileScript.mkdirs();
            try (InputStream isStream = this.getClass().getClassLoader().getResourceAsStream(internalScript)) {
                Files.copy(isStream, outputScript);
                switch (OS_TYPE) {
                    case Linux:
                    case Mac:
                        makeExecutable(outputScript.toString());
                        break;
                }
            }
            catch(IOException ioe){
                throw new RuntimeException(ioe);
            }
        }

        return outputScript;
    }

    /**
     * Provides the script to use to force in directory execution.
     * @return The path of the script.
     */
    public Path getScript() {
        return getScriptPath(IScript.getInstance(OS_TYPE).getScript());
    }

    /**
     * The directory to run the docker command.
     * @return The directory to run the docker command.
     */
    public Path getDirectory() {
        return directory;
    }

    /**
     * Must hold the execute logic based on the context provided.
     *
     * @param logic The executed logic with context.
     */
    public void execute(Consumer<IContext> logic) {
        logic.accept(new IContext() {
            @Override
            public String getCommand() {
                return DockerExecutor.this.getCommand();
            }

            @Override
            public String getDockerExe() {
                return DockerExecutor.this.getDockerExe();
            }

            @Override
            public List<String> getArgs() {
                return DockerExecutor.this.getArgs();
            }

            @Override
            public List<String> getOpts() {
                return DockerExecutor.this.getOpts();
            }

            @Override
            public Path getScript() {
                return DockerExecutor.this.getScript();
            }

            @Override
            public Path getDirectory() {
                return DockerExecutor.this.getDirectory();
            }

            @Override
            public String getExecutable() {
                return DockerExecutor.this.getExecutable();
            }

            @Override
            public List<String> getExecArgs() {
                return DockerExecutor.this.getExecArgs();
            }
        });
    }

    /**
     * The docker command arguments.
     *
     * @return An array of arguments.
     */
    public List<String> getArgs() {
        return new ArrayList<>(args);
    }

    /**
     * The options before the docker command.
     * @return An array of options.
     */
    public List<String> getOpts() {
        return new ArrayList<>(opts);
    }

    /**
     * The executable to be used in task exec.
     * @return The executable name.
     */
    public String getExecutable() {
        String dockerExe = getDockerExe();

        if (dockerExe==null) {
            return null;
        }

        if (forceDirectory && null!=directory && null!=getScript()) {
            return quoteString(getScript().toString(), OS_TYPE);
        }
        else {
            return dockerExe;
        }
    }

    /**
     * The arguments for the executable.
     *
     * @return An array of executable args.
     */
    public List<String> getExecArgs() {
        List<String> execArgs = new ArrayList<>();
        if (forceDirectory && null!=directory && null!=getScript()) {
            execArgs.add(quoteString(directory.toString(), OS_TYPE));
            execArgs.add(getDockerExe());
        }

        if (null!=opts && !opts.isEmpty()) {
            execArgs.addAll(opts);
        }

        if (null!=args && !args.isEmpty()) {
            execArgs.addAll(args);
        }

        return execArgs;
    }

    /**
     * The full command that will be executed.
     *
     * @return The full command.
     */
    public String getCommand() {
        String executable = getExecutable();
        final String DELIM=" ";

        if (null==executable) {
            return null;
        }

        StringBuilder command = new StringBuilder(executable);
        getExecArgs().forEach(___arg -> command.append(DELIM).append(String.join(DELIM, ___arg)));

        return command.toString();
    }

    private static class ExecutorBuilder {

        private final List<String> args = new ArrayList<>();
        private final List<String> opts = new ArrayList<>();
        private String knownExecutable;
        private boolean forceDirectory;
        private Path directory;

        public ExecutorBuilder addKnownDockerExe(String knownDockerExe) {
            this.knownExecutable = knownDockerExe;
            return this;
        }

        public ExecutorBuilder addArg(String arg) {
            if (null!=arg) {
                args.add(arg);
            }
            return this;
        }

        public ExecutorBuilder addArgs(List<String> args) {
            if (null!=args) {
                this.args.addAll(args);
            }
            return this;
        }

        public ExecutorBuilder addOpts(List<String> opts) {
            if (null!=opts) {
                this.opts.addAll(opts);
            }
            return this;
        }

        public ExecutorBuilder addForceDirectory(boolean forceDirectory) {
            this.forceDirectory = forceDirectory;
            return this;
        }

        public ExecutorBuilder addDirectory(File directory) {
            if (null!=directory) {
                this.directory = directory.toPath();
            }
            return this;
        }

        public DockerExecutor build() {
            return new DockerExecutor(this);
        }
    }

    /**
     * The builder of the DockerExecutor
     *
     * @return An instance of ExecutorBuilder.
     */
    public static ExecutorBuilder getBuilder() {
        return new ExecutorBuilder();
    }
}
