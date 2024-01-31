package xyz.ronella.gradle.plugin.simple.docker.args

import org.gradle.api.provider.ListProperty
import xyz.ronella.gradle.plugin.simple.docker.ext.SimpleDockerPluginExtension
import xyz.ronella.gradle.plugin.simple.docker.task.DockerTask

final class ArgumentManager {
    final private static List<Closure> ARGUMENTS = []

    static {
        addImageArg()
    }

    private ArgumentManager() {}

    private static void processArg(Closure instanceCheck, Closure casting, Closure argsConfiguration) {
        if (instanceCheck.call()) {
            argsConfiguration.call(casting.call())
        }
    }

    private static addImageArg() {
        ARGUMENTS.add {___task, ___args, ___ext ->
            processArg({___task instanceof IImageArg},{___task as IImageArg}) {
                if (it.image.present) {
                    ___args.add("${it.image.get()}")
                }
            }
        }
    }

    /**
     * Process the arguments of a particular task.
     *
     * @param task An instance of the task that is being processed.
     * @param args An instance of the collection of arguments of the task.
     * @param ext An instance of SimpleKeytoolPluginExtension.
     */
    static processArgs(DockerTask task, ListProperty<String> args, SimpleDockerPluginExtension ext) {
        Collections.unmodifiableList(ARGUMENTS).forEach{it.call(task, args, ext)}
    }
}
