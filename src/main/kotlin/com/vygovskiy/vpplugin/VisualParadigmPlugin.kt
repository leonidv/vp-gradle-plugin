package com.vygovskiy.vpplugin

import com.vygovskiy.vpplugin.tasks.*
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskContainer
import kotlin.reflect.KClass

class VisualParadigmPlugin : Plugin<Project> {
    companion object {
        val taskNames = mapOf(
            CreatePluginDir::class to "createPluginDir",
            DeletePluginDir::class to "deletePluginDir",
            CopyClasses::class to "copyClasses",
            CopyDependencies::class to "copyDependencies",
            AddPluginXmlTemplate::class to "addPluginXmlTemplate"
        )
    }

    private fun TaskContainer.registerVPTask(
        taskClass: KClass<out BaseTask>,
        extension: VisualParadigmExtension,
        customInit: ((VisualParadigmExtension, BaseTask) -> Unit)? = null
    ) {
        try {
            val name = taskNames[taskClass]!!
            this.register(name, taskClass.java) {task ->
                task.group = "visual paradigm"

                task.getPluginsDir().set(extension.getPluginsDir())
                task.getPluginName().set(extension.getPluginName())
                task.getTemplateFile().set(extension.getTemplateFile())
                if (customInit != null) {
                    customInit(extension, task)
                };
            }
        } catch (e: Exception) {
            throw VPPluginException("Can't add task [${taskClass.simpleName}]", e)
        }
    }


    override fun apply(project: Project) {
        val extension = project.extensions.create("visualParadigm", VisualParadigmExtension::class.java)

        with(project.tasks) {
            registerVPTask(CreatePluginDir::class, extension)
            registerVPTask(DeletePluginDir::class, extension)
            registerVPTask(CopyClasses::class, extension)
            registerVPTask(CopyDependencies::class, extension)
            registerVPTask(AddPluginXmlTemplate::class, extension)
        }

        val addPluginXmlTemplateTask = project.tasks.getByName(taskNames[AddPluginXmlTemplate::class]) as AddPluginXmlTemplate
        addPluginXmlTemplateTask.run()

    }
}