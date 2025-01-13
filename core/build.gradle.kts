plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.mosalab.spacecraftsapp.core"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":core"))
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

ksp {
    arg("room.schemaLocation", "$projectDir/schemas") // Provide schema export directory
}