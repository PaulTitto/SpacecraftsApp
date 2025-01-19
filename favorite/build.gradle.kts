plugins {
<<<<<<< HEAD
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.mosalab.spacecraftsapp.favorite"
=======
    alias(libs.plugins.android.dynamic.feature)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
}
android {
    namespace = "com.mosalab.spacecraftisro.favorite"
>>>>>>> 0ad0322 (Initial commit)
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
<<<<<<< HEAD
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
=======
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
>>>>>>> 0ad0322 (Initial commit)
    }
}

dependencies {
<<<<<<< HEAD
    ksp("com.google.devtools.ksp:symbol-processing-api:1.9.0-1.0.13")
//    implementation(project(":app"))
    implementation(project(":core"))
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.2")
    implementation("androidx.room:room-runtime:2.5.0")
    ksp("androidx.room:room-compiler:2.5.0")
    implementation("androidx.compose.ui:ui:1.5.1")
    implementation("androidx.compose.material:material:1.5.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.dagger:hilt-android:2.44")
    ksp("com.google.dagger:hilt-compiler:2.44")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.room:room-runtime:2.5.0")
    implementation("androidx.room:room-ktx:2.5.0")
    ksp("androidx.room:room-compiler:2.5.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.44")
    // Hilt
    implementation("com.google.dagger:hilt-android:2.48")

    // Hilt untuk Jetpack Compose
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("com.google.dagger:hilt-android:2.44")
    ksp("com.google.dagger:hilt-compiler:2.44")

    ksp("com.google.dagger:hilt-compiler:2.44")
}
=======
    implementation(project(":app"))
    implementation(project(":core"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
>>>>>>> 0ad0322 (Initial commit)
