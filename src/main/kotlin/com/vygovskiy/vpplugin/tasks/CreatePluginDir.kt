package com.vygovskiy.vpplugin.tasks

import org.gradle.api.tasks.TaskAction
import java.nio.file.Files

abstract class CreatePluginDir : BaseTask() {
    @TaskAction
    fun run() {
        if (Files.notExists(super._pluginDir)) {
            Files.createDirectories(super._pluginDir)
        }
    }

}