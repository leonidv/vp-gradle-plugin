package com.vygovskiy.vpplugin

import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional


abstract class VisualParadigmExtension {
    @Input
    @Optional
    abstract fun getPluginsDir() : Property<String>

    @Input
    @Optional
    abstract fun getPluginName() : Property<String>
}