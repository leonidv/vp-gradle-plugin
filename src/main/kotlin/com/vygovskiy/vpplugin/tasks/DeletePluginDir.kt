package com.vygovskiy.vpplugin.tasks

import org.gradle.api.tasks.TaskAction

abstract class DeletePluginDir : BaseTask() {
    @TaskAction
    fun run() {
        super._pluginDir.toFile().deleteRecursively()
    }
}