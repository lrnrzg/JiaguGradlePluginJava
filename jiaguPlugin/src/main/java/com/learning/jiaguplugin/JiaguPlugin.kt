package com.learning.jiaguplugin

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author Zhu
 * @date 4/11/21 3:09 PM
 * @desc 插件：编译阶段，做一些事情
 */
open class JiaguPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val jiagu = project.extensions.create("jiagu", JiaguExt::class.java)
        project.afterEvaluate { project ->
            val android = project.extensions.getByType(AppExtension::class.java) // 更优雅
            // build variant
            android.applicationVariants.all { applicationVariant ->
                // debug or release
                val name = applicationVariant.name
                val outputs = applicationVariant.outputs
                outputs.all { baseVariantOutput -> // apk 文件
                    val outputFile = baseVariantOutput.outputFile
                    project.tasks.create("jiagu$name", JiaguTask::class.java, outputFile, jiagu)
                }
            }
        }
    }
}