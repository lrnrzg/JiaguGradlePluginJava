package com.learning.jiaguplugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File
import javax.inject.Inject

/**
 * @author Zhu
 * @date 4/11/21 4:15 PM
 * @desc
 */
open class JiaguTask @Inject constructor(private val apk: File, private val jiaguExt: JiaguExt) : DefaultTask() {
    @TaskAction
    fun extJiagu() {
        project.exec { execSpec -> execSpec.commandLine("java", "-jar", jiaguExt.jiaguToolPath, "-login", jiaguExt.username, jiaguExt.password) }
        project.exec { execSpec ->
            execSpec.commandLine("java", "-jar", jiaguExt.jiaguToolPath, "-importsign", jiaguExt.keystorePath,
                    jiaguExt.keystorePassword, jiaguExt.keystoreAlias,
                    jiaguExt.keystoreAliasPassword)
        }
        project.exec { execSpec -> execSpec.commandLine("java", "-jar", jiaguExt.jiaguToolPath, "-jiagu", apk.absolutePath, apk.parentFile.absolutePath, "-autosign") }
    }

    init {
        group = "jiagu" // 设置 task 所在的分组。
    }
}