package com.vygovskiy.vpplugin

import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction

abstract class DemoTask : DefaultTask() {

//    @Input
//    @Optional
//    abstract fun getFirstName() : Property<String>
//
//    @Input
//    @Optional
//    abstract fun getFolder() : DirectoryProperty

    @TaskAction
    fun sayHello() {
//        val name = if (getFirstName().isPresent) {
//            getFirstName().get()
//        } else {
//            "incognito"
//        }
         println("Hello,")
    }
}