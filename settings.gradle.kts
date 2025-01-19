<<<<<<< HEAD
//pluginManagement {
//    repositories {
//        google {
//            content {
//                includeGroupByRegex("com\\.android.*")
//                includeGroupByRegex("com\\.google.*")
//                includeGroupByRegex("androidx.*")
//            }
//        }
//        mavenCentral()
//        gradlePluginPortal()
//    }
//}
//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        google()
//        mavenCentral()
//    }
//}
//
//rootProject.name = "Spacecrafts App"
//include(":app")
//include(":core")
//include(":favorite")



pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
=======
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
>>>>>>> 0ad0322 (Initial commit)
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
<<<<<<< HEAD

rootProject.name = "Spacecrafts App"
include(":app", ":core", ":favorite")
=======
rootProject.name = "Spacecraft ISRO"
>>>>>>> 0ad0322 (Initial commit)
include(":app")
include(":core")
include(":favorite")
