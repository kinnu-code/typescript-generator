
plugins {
    id("com.gradle.plugin-publish") version "1.3.1"
    id("maven-publish")
}

group = "cz.habarta.typescript-generator"
version = "3.2-KINNU"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(19))
    }
}



dependencies {
//    api("cz.habarta.typescript-generator:typescript-generator-gradle-plugin:${version}")
    api("cz.habarta.typescript-generator:typescript-generator-gradle-plugin:3.2-SNAPSHOT")
}

gradlePlugin {
    plugins {
        create("typescriptGeneratorPlugin") {
            id = "cz.habarta.typescript-generator"
            implementationClass = "cz.habarta.typescript.generator.gradle.TypeScriptGeneratorPublishedPlugin"
            displayName = "Typescript-generator Gradle plugin"
            description = "Generates TypeScript from Java - JSON declarations, REST service client"
        }
    }
}

publishing {
    repositories {
        maven {
            name = "kinnu-gradle"
            url = uri("https://kinnu-471112671295.d.codeartifact.eu-west-1.amazonaws.com/maven/kinnu-gradle/")
            credentials {
                username = "aws"
                password = properties["codeartifactToken"]?.toString()
            }
        }
    }
}
