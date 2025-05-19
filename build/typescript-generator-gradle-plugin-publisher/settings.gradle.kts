
pluginManagement {
    val codeartifactToken: String by settings
    repositories {
        mavenCentral()
        gradlePluginPortal()

        maven {
            name = "kinnu-gradle"
            url = uri("https://kinnu-471112671295.d.codeartifact.eu-west-1.amazonaws.com/maven/kinnu-gradle/")
            credentials {
                username = "aws"
                password = "$codeartifactToken"
            }
        }
    }
}

dependencyResolutionManagement {
    val codeartifactToken: String by settings
    repositories {
        mavenCentral()
//    mavenLocal()
//    maven {
//        name = "kinnu-local"
//        url = uri("file:///home/abmue/Downloads/local-maven-repo")
//    }

        maven {
            name = "kinnu-gradle"
            url = uri("https://kinnu-471112671295.d.codeartifact.eu-west-1.amazonaws.com/maven/kinnu-gradle/")
            credentials {
                username = "aws"
                password = "$codeartifactToken"
            }
        }
    }
}