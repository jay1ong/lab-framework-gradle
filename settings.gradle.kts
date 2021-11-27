//pluginManagement {
//    repositories {
//        maven {
//            url "https://maven.aliyun.com/repository/gradle-plugin"
//        }
//        gradlePluginPortal()
//    }
//}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        mavenLocal()
        maven {
            setUrl("https://serverless-100020665958-maven.pkg.coding.net/repository/lab/repo/")
            credentials {
                username = "repo-1637982646840"
                password = "813d50e1cbcbeabe06a1996c9a9c410348492821"
            }
        }
        maven {
            setUrl("https://maven.aliyun.com/repository/public/")
        }
        maven {
            setUrl("https://maven.aliyun.com/repository/central/")
        }
        mavenCentral()
    }
}

rootProject.name = "lab-framework-gradle"

include("lab-axon-gradle")
include("lab-core-gradle")
include("lab-dependencies-gradle")
include("lab-data-gradle:lab-data-jpa-gradle")
findProject(":lab-data-gradle:lab-data-jpa-gradle")?.name = "lab-data-jpa-gradle"
include("lab-mq-gradle")
include("lab-snowflake-gradle")
include("lab-web-gradle")
include("lab-test-gradle")
include("lab-autoconfig-gradle")
