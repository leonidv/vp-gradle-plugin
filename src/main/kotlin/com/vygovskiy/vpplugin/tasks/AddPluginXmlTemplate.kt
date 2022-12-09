package com.vygovskiy.vpplugin.tasks

import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.OutputDirectories
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class AddPluginXmlTemplate : BaseTask() {

    @TaskAction
    fun run() {
        if (super._templateFile.exists()) {
            return
        }

        val resourcesDir = super._templateFile.parentFile
        if (!resourcesDir.isDirectory) {
            resourcesDir.mkdirs()
        }

        this::class.java.getResourceAsStream("/plugin.xml.ftl").use {templateInputStream ->
            super._templateFile.outputStream().use {
                templateInputStream.copyTo(it, bufferSize = 8000)
            }
        }

        project.logger.info("freemarker template of plugin xml: ${super._templateFile.absolutePath}")
    }
}