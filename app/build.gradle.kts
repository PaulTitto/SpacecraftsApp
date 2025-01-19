plugins {
<<<<<<< HEAD
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.mosalab.spacecraftsapp"
    compileSdk = 35
    dynamicFeatures += setOf(":favorite")
//    dynamicFeatures += ":favorite"
//    dynamicFeatures += listOf(":favorite")
//    dynamicFeatures += mutableSetOf(":favorite")
//    dynamicFeatures = listOf(":favorite")
    defaultConfig {
        applicationId = "com.mosalab.spacecraftsapp"
=======
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.mosalab.spacecraftisro"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mosalab.spacecraftisro"
>>>>>>> 0ad0322 (Initial commit)
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
<<<<<<< HEAD
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

//    dynamicFeatures = listOf(":favorite") // Specify the dynamic feature module

=======

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

>>>>>>> 0ad0322 (Initial commit)
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
<<<<<<< HEAD
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
=======
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    dynamicFeatures += setOf(":favorite")
>>>>>>> 0ad0322 (Initial commit)
}

dependencies {
    implementation(project(":core"))
<<<<<<< HEAD
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.compose.ui:ui:1.5.1")
    implementation("androidx.navigation:navigation-compose:2.7.2")
    implementation("com.google.dagger:hilt-android:2.44")
    ksp("com.google.dagger:hilt-compiler:2.44")
    ksp("com.google.devtools.ksp:symbol-processing-api:1.9.0-1.0.13")
    // Compose
    implementation("androidx.compose.ui:ui:1.5.1")
    implementation("androidx.navigation:navigation-compose:2.7.2")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.48")

    // Hilt untuk Jetpack Compose
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("com.google.dagger:hilt-android:2.44")
    ksp("com.google.dagger:hilt-compiler:2.44")

    // KSP
    ksp("com.google.devtools.ksp:symbol-processing-api:1.9.0-1.0.13")


    implementation("androidx.room:room-runtime:2.5.0")
    implementation("androidx.room:room-ktx:2.5.0")
    ksp("androidx.room:room-compiler:2.5.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.44")
    ksp("com.google.dagger:hilt-compiler:2.44")
    // Library lainnya
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
=======
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.junit.ktx)

}
>>>>>>> 0ad0322 (Initial commit)
