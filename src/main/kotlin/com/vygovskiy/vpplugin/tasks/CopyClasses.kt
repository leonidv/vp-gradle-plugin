package com.vygovskiy.vpplugin.tasks

import com.vygovskiy.vpplugin.VisualParadigmPlugin
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class CopyClasses : BaseTask() {

    init {
        dependsOn(
            "build",
            VisualParadigmPlugin.taskNames[CreatePluginDir::class]
        )
    }

    private fun findClassesDirectories(): List<File> {
        val classesDir = File(project.buildDir, "classes")
        return classesDir
            .listFiles {dir -> dir.list()!!.contains("main")}!! // can't be null here by java code
            .map {File(it, "main")}
    }


    @TaskAction
    fun run() {
        val pluginDir = super._pluginDir.toFile();
        findClassesDirectories().forEach {classesDir ->
            project.logger.info("copy classes from ${classesDir.absolutePath}")
            classesDir.copyRecursively(pluginDir, true)
        }
    }
}