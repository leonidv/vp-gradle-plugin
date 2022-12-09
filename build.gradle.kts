import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    id("java-gradle-plugin")
    `maven-publish`
}

group = "com.vygovskiy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("org.freemarker:freemarker:2.3.31")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

gradlePlugin {
    plugins {
        create("visualParadigmPlugins") {
            id = "com.vygovskiy.vpplugin"
            implementationClass = "com.vygovskiy.vpplugin.VisualParadigmPlugin"
        }
    }
}