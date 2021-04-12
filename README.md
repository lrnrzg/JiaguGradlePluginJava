# JiaguGradlePluginJava
自定义 gradle 插件 对 apk 「360加固」

1. build.gradle(project)添加对插件的依赖
   
 声明插件所在的仓库 `mavenLocal()` 以及插件类所在路径 `classpath 'com.zhu:jiagu:1.0.0'`
 
 2. build.gradle(app) 引入插件 以及配置参数
  
  `id 'com.jiaguPlugin'`
  
  
  jiagu {
    username '16675379395'
    password 'xxxx'
    keystorePath file('key').absolutePath
    keystorePassword 'xx'
    keystoreAlias 'xxx'
    keystoreAliasPassword 'xxxx'
    jiaguToolPath 'jiagu.jar'
  }

  

 
 
