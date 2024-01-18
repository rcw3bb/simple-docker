package xyz.ronella.gradle.plugin.simple.docker

import static org.junit.jupiter.api.Assertions.*

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DockerTaskTest {
    private Project project

    @BeforeEach
    void initProject() {
        project = ProjectBuilder.builder().build()
        project.pluginManager.apply 'xyz.ronella.simple-docker'
        project.extensions.simple_docker.verbose = true
        project.extensions.simple_docker.noop = true
    }

    @Test
    void testCommand() {
        def dockerTask = project.tasks.dockerTask
        dockerTask.directory = new File("D:/dev/tmp/simple-docker")
        dockerTask.executeCommand()

        def executor = dockerTask.executor
        def dockerExe = executor.dockerExe
        def cmd = executor.command
        def script = executor.script.toString()

        assertEquals("\"${script}\" \"D:\\dev\\tmp\\simple-docker\" ${dockerExe} --help".toString(), cmd)
    }

    @Test
    void testVerbose() {
        assertTrue(project.extensions.simple_docker.verbose.get())
    }

    @Test
    void testNoop() {
        assertTrue(project.extensions.simple_docker.noop.get())
    }

    @Test
    void testNodockerInstalled() {

        def dockerTask = project.tasks.dockerTask
        project.extensions.simple_docker.noop = false
        def testExt = project.extensions.simple_docker_test
        testExt.no_docker_installed = true

        dockerTask.executeCommand()

        assertEquals("docker.exe not found. Please install docker application and try again.", testExt.test_message)
    }

}