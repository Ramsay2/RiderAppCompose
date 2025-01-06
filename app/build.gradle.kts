plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.daggerHilt)
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.sachin.riderappcompose"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.sachin.riderappcompose"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
      create("release"){
          storeFile = rootProject.file("keystore")
          keyAlias = "sachin"
          keyPassword = "sachinsharma"
          storePassword = "sachinsharma"
      }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.androidx.hilt.navigation.fragment)
    implementation(libs.androidx.hilt.navigation)


    implementation(libs.androidx.hilt.work)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.androidx.multidex)
    implementation(libs.play.services.mlkit.barcode.scanning)
    // CameraX core library using the camera2 implementation
    implementation (libs.androidx.camera.camera2)
    // If you want to additionally use the CameraX Lifecycle library
    implementation( libs.androidx.camera.lifecycle)
    // If you want to additionally use the CameraX View class
    implementation (libs.androidx.camera.view)
    // If you want to additionally use the CameraX Extensions library
    implementation (libs.androidx.camera.extensions)

    // Import the BoM for the Firebase platform
    implementation (platform(libs.firebase.bom))
    // Declare the dependencies for the Crashlytics and Analytics libraries
    // When using the BoM, you don"t specify versions in Firebase library dependencies
    implementation (libs.firebase.crashlytics.ktx)
    implementation (libs.firebase.analytics.ktx)
    implementation (libs.firebase.messaging.ktx)
    implementation (libs.firebase.perf)
    implementation (libs.firebase.firestore.ktx)

    // HTTP
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.okhttp)

    // Room Persistence
    implementation (libs.androidx.room.runtime)
    ksp (libs.androidx.room.compiler)
    // For Kotlin use kapt instead of annotationProcessor
    implementation (libs.androidx.room.ktx)
    testImplementation (libs.androidx.room.testing)
    // location
    implementation (libs.play.services.location)

    implementation (libs.org.eclipse.paho.client.mqttv3)
    //paging
    implementation (libs.androidx.paging.runtime.ktx)

    // LifeCycle Aware Components
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.livedata.ktx)
    implementation (libs.androidx.lifecycle.common.java8)
    implementation (libs.androidx.lifecycle.runtime.ktx)
    // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
    implementation (libs.androidx.lifecycle.process)
    implementation (libs.androidx.work.runtime.ktx)

    implementation(libs.kotlinx.serialization.json)

    //Dagger Hilt
    implementation (libs.hilt.android)
    kapt (libs.hilt.compiler)
    implementation (libs.androidx.hilt.navigation.compose)

    implementation (libs.otpview.compose)

}
