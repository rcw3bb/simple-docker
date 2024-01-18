package xyz.ronella.gradle.plugin.simple.docker

import static org.junit.jupiter.api.Assertions.*

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DockerVersionTest {

    private Project project

    @BeforeEach
    void initProject() {
        project = ProjectBuilder.builder().build()
        project.pluginManager.apply 'xyz.ronella.simple-docker'
        project.extensions.simple_docker.verbose = true
        project.extensions.simple_docker.noop = true
    }

    @Test
    void testNoParameters() {
        def dockerTask = project.tasks.dockerVersion

        dockerTask.executeCommand()

        def executor = dockerTask.executor
        def dockerExe = executor.dockerExe
        def cmd = executor.command

        assertEquals("${dockerExe} --version".toString(), cmd)
    }

    @Test
    void testDirectory() {
        def dockerTask = project.tasks.dockerVersion

        dockerTask.directory=new File('D:\\dev\\tmp\\simple-docker')

        dockerTask.executeCommand()

        def executor = dockerTask.executor
        def dockerExe = executor.dockerExe
        def cmd = executor.command

        assertEquals("${dockerExe} --version".toString(), cmd)
    }
}
