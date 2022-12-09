<?xml version="1.0" encoding="UTF-8" ?>

<plugin
        id="#pluginId#"
        name="#pluginId#"
        description="My plugin #pluginId#"
        provider="#user#"
        class="utils.Plugin">

    <!-- Gradle script replaces this tag with a references to libs -->
    <runtime/>

    <actionSets>
        <actionSet id="com.vygovskiy.vpplugin.#pluginId#">
            <toolbar
                    id="com.vygovskiy.vpplugin.#pluginId#.toolbar"
                    orientation="north"
                    index="last"/>

            <action
                    id="com.vygovskiy.vpplugin.RelationshipsHotFix"
                    actionType="generalAction"
                    label="Reload plugins"
                    tooltip="Reload classes of all plugins"
                    style="normal"
                    toolbarPath="com.vygovskiy.vpplugin.#pluginId#.toolbar/#">
                <actionController class="com.vygovskiy.vpplugin.RelationshipsHotFix"/>
            </action>
        </actionSet>
    </actionSets>
</plugin>