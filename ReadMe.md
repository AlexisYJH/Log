# [使用jitpack发布你自己的依赖库](https://blog.csdn.net/endlife99/article/details/122235366)
## 1. 新建library Module
在该module工程的build.gradle配置文件下，增加如下内容
```
plugins {
    ...
    id 'maven-publish'
}
group = 'com.github.AlexisYJH'
version = '1.0'
 
 
 
afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            release(MavenPublication) {
                from components.release
                groupId = 'com.github.AlexisYJH'
                artifactId = 'log'
                version = '1.0'
            }
        }
    }
}
 
dependencies {
    ...
}
```
查看gitpack官方提供的build.gradle文件的编写，https://github.com/jitpack/android-example/blob/master/library/build.gradle

## 2. 上传library工程，创建release版本
1. push工程到github
2. 给工程打包一个release版本

## 3. 在jitpack上编译该release版本
将你的项目git地址（如我的项目地址是https://github.com/AlexisYJH/Log ）输入到jitpack，
点击Look up按钮，就可以看到你刚才打的release版本，点击Get it按钮，jitpack就会开始编译，编译成功结果会显示绿色，失败则是红色

## 4. 使用你的依赖库
在工程的build.gradle文件下，增加maven依赖
```
repositories {
        maven { url 'https://jitpack.io' }
  }
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
在app的build.gradle中增加依赖

