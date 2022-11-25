package com.vygovskiy.vpplugin.tasks

import com.vygovskiy.vpplugin.VPPluginException
import org.apache.commons.lang3.SystemUtils
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.Optional
import java.nio.file.Files
import kotlin.io.path.Path

abstract class BaseTask : DefaultTask() {
    companion object {
        fun error(msg: String): Nothing {
            throw VPPluginException("$msg Please, set Visual Paradigm plugin dir manually")
        }
    }

    @Input
    @Optional
    abstract fun getPluginsDir(): Property<String>

    @Input
    @Optional
    abstract fun getPluginName(): Property<String>

    @Internal
    protected val _pluginsDir: String = getPluginsDir().getOrElse(getDefaultPluginsDir())

    @Internal
    protected val _pluginName: String = getPluginName().getOrElse(project.name)

    @Internal
    protected val _pluginDir = Path(_pluginsDir,_pluginName);

    private fun getDefaultPluginsDir(): String {
        val userHome = System.getProperty("user.home");
        val vpSettingsDir: String =
            when {
                SystemUtils.IS_OS_LINUX -> ""
                SystemUtils.IS_OS_WINDOWS -> "$userHome\\AppData\\Roaming\\VisualParadigm\\"
                SystemUtils.IS_OS_MAC -> "$userHome/Library/Application Support/VisualParadigm/"
                else -> error("Can't detect Operation System.")
            }

        if (!Files.isDirectory(Path(vpSettingsDir))) {
            throw VPPluginException("Default VisualParadigm folder for plugins is not found ($vpSettingsDir).")
        }
        return vpSettingsDir + "plugins";
    }


}