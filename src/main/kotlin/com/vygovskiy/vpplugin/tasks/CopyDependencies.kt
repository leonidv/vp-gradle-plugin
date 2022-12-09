package com.vygovskiy.vpplugin.tasks

import org.gradle.api.tasks.TaskAction
import java.io.File


abstract class CopyDependencies : BaseTask() {

    @TaskAction
    fun run() {
        val cfg = project.configurations.named("runtimeClasspath")
        val pluginLibDir = File(super._pluginDir.toFile(), "lib");
        if (!pluginLibDir.isDirectory) {
            pluginLibDir.mkdirs()
        }
        cfg.get().forEach {jar ->
            val dest = File(pluginLibDir, jar.name);
            jar.copyTo(dest, overwrite = true, bufferSize = 10*1024);
        }
    }
}