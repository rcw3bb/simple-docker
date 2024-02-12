# Simple Docker Gradle Plugin

The plugin that allows you access to docker commands in gradle as task.

# Pre-requisite

* Java 17 (Minimum)
* Windows/Linux/MacOS
* Docker Application

## Plugging in the simple-Docker

In your **build.gradle** file add the following plugin:

```groovy
plugins {
    id "xyz.ronella.simple-Docker" version "1.0.0"
}
```

> A **Simple Docker tasks** group will be added to the available tasks at your disposal. You can use the following command to see them:
>
> ```
> gradlew tasks --group "Simple docker"
> ```
>
> Expect to see the available tasks like the following:
>
> ```
> Simple docker tasks
> -------------------
> dockerListContainers - A convenience task for listing the containers
> dockerListImages - A convenience task for listing the images
> dockerPrune - A convenience task for pruning unused images
> dockerVersion - A convenience docker --version command
> ```

## Plugin Properties

| Property | Description | Type | Default |
|-----|------|------|-----|
| simple_docker.dockerFile.tag | The tag to use when working with the tasks under **simple docker - dockerfile** group. | String |  |
| simple_docker.noop | This is like the verbose property with the addition of not running the docker command. This is good for debugging on what command parameters it is trying to execute. | boolean | false |
| simple_docker.verbose | The plugin will to display more information on the console *(e.g. the actual docker command being run)*. | boolean | false |

## Using DockerTask

The **DockerTask** is the base implementation. The **child tasks** normally just have a default management command and/or arguments *(e.g. **DockerCompose** task has **compose as the management command**)*. 

DockerTask is not exposed by default and to use it, the following package must be imported first in build.gradle:

```groovy
import xyz.ronella.gradle.plugin.simple.docker.task.*
```

Whatever you can do with the **docker command** in console you can do it in gradle with this task. 

| Task Name  | Task Property | Type     | Comment                                                      |
| ---------- | ------------- | -------- | ------------------------------------------------------------ |
| DockerTask | args          | String[] | The argument of the command.                                 |
|            | command       | String   | The command under the management *(e.g. buildx, compose)* command |
|            | management    | String   | The management command *(e.g. buildx, compose)*              |
|            | options       | String[] | These are the options for the docker command itself and it is normally goes before the management command. |

#### Example

Translate the following **Docker clone command** into a task in gradle:

```
docker buildx build --tag xyz.ronella.sample/simple-docker-test:1.0.0-SNAPSHOT .
```

**Use the task itself using the following:**

```groovy
task buildImage(type: DockerTask) {
    management = 'buildx'
    command = 'build' //Docker Command
    args = ['--tag', 'xyz.ronella.sample/simple-docker-test:1.0.0-SNAPSHOT', '.'] //The docker build arguments
}
```

**Use the child task DockerBuildX with the following:**

```groovy
task buildImage(type: DockerBuildX) {
    command = 'build' //Docker Command
    args = ['--tag', 'xyz.ronella.sample/simple-docker-test:1.0.0-SNAPSHOT', '.'] //The docker build arguments
}
```

> You don't need to set the **management property** because it was already preset with **buildx**.

## Child Tasks

The child tasks are the convenience tasks derived from DockerTask where the management property already has value.

| Task Name       | Management  Property |
| --------------- | ------------- |
| DockerBuilder | builder |
| DockerBuildX | buildx  |
| DockerCompose | compose |
| DockerContainer | container |
| DockerContext | context |
| DockerDev | dev |
| DockerExtension | extension |
| DockerFeedback | feedback |
| DockerImage | image    |
| DockerInit | init     |
| DockerManifest | manifest |
| DockerNetwork | network |
| DockerPlugin | plugin |
| DockerSBOM | sbom |
| DockerScan | scan |
| DockerScout | scout |
| DockerSystem | system |
| DockerTrust | trust |
| DockerVolume | volume |

## Terminal Arguments (zargs)

All the tasks supports terminal arguments *(i.e. zargs)*. These are the arguments that always after the provided args.

```groovy
task buildImage(type: DockerBuildX) {
    command = 'build' //Docker Command
    args = ['--tag', 'xyz.ronella.sample/simple-docker-test:1.0.0-SNAPSHOT'] //The docker build arguments
    zargs = ['.'] //Ensures that the argument is always after the args parameter.
}
```

## Root Dockerfile

The Dockerfile that exists in the root directory of the project. If this file exists the following grouped tasks will be available:

```
Simple docker - Dockerfile tasks
--------------------------------
dockerFileBuild - A task for building the image based on Dockerfile
dockerFileDelete - A task that will delete the image created by the dockerFileBuild task
dockerFileList - A task that will list the image created by the dockerFileBuild task
```

To use any task within this group the following must property must be set:

```groovy
simple_docker.dockerFile.tag
```

**Example**

```groovy
simple_docker.dockerFile.tag = "${group}/${project.name}:${version}"
```

## Root docker-compose.yml

The docker-compose.yml that exists in the root directory of the project. If this file exists the following grouped tasks will be available:

```
Simple docker - Compose tasks
-----------------------------
dockerComposeDown - A task for removing containers of docker composed services
dockerComposePause - A task for pausing docker composed services
dockerComposeRestart - A task for restarting docker composed services
dockerComposeStart - A task for starting docker composed services
dockerComposeStop - A task for stopping docker composed services
dockerComposeUnpause - A task for unpausing docker composed services
dockerComposeUp - A task for initializing and starting docker composed services
```

## Sample Usages

### build.gradle file

```groovy
task startNginx(type: DockerContainer) {
    command = 'run'
    args = ['-d', '-p', '8080:80', '--rm', '--name=test-nginx']
    zargs = ['nginx']
}

task stopNginx(type: DockerContainer) {
    command = 'stop'
    args = ['test-nginx']
}
```

### Start nginx

```
gradlew startNginx
```

Nginx will start and the host port is 8080. Thus, you can access it using the following address:

http://localhost:8080/

### Stop nginx

```
gradlew stopNginx
```

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## [Build](BUILD.md)

## [Changelog](CHANGELOG.md)

## Author

* Ronaldo Webb
