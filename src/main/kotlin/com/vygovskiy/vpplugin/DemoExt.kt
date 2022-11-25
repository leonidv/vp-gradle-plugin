package com.vygovskiy.vpplugin

import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property

abstract class DemoExt  {
    abstract fun getName() : Property<String>

    abstract fun getFolder() : DirectoryProperty
}