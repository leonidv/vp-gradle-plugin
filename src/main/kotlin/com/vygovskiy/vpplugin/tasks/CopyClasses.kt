package com.vygovskiy.vpplugin.tasks

import org.gradle.api.tasks.TaskAction

abstract class CopyClasses : BaseTask() {

    init {
        dependsOn("build")

    }

    @TaskAction
    fun run() {
        project.tasks.forEach {t ->
            println("${t.name} ${t.javaClass}")
        }

        println(project.buildDir.absolutePath)
    }
}