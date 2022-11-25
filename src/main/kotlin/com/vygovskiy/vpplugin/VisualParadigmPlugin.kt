package com.vygovskiy.vpplugin

import com.vygovskiy.vpplugin.tasks.CreatePluginDir
import com.vygovskiy.vpplugin.tasks.DeletePluginDir
import com.vygovskiy.vpplugin.tasks.BaseTask
import com.vygovskiy.vpplugin.tasks.CopyClasses
import org.gradle.api.Plugin
import org.gradle.api.Project

class VisualParadigmPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val extension = project.extensions.create("visualParadigm", VisualParadigmExtension::class.java)

        val initTask = {task: BaseTask ->
            task.group = "visual paradigm"

            task.getPluginsDir().set(extension.getPluginsDir())
            task.getPluginName().set(extension.getPluginName())
        }

        project.tasks.register("createPluginDir", CreatePluginDir::class.java, initTask)

        project.tasks.register("deletePluginDir", DeletePluginDir::class.java, initTask)

        project.tasks.register("copyClasses", CopyClasses::class.java, initTask)

//        val extension = project.extensions.create("demo", DemoExt::class.java)
//        project.tasks.register("hello", DemoTask::class.java) {task ->
//            task.getFirstName().set(extension.getName())
//            task.getFolder().set(extension.getFolder())
//        }

    }
}