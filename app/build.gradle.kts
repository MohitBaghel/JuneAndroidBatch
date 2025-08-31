plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
//    alias(libs.plugins.kotlin.android.extension)
}

android {
    namespace = "com.mb.juneandroidbatch"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mb.juneandroidbatch"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

   buildFeatures{
       viewBinding = true
       dataBinding = true
   }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.room.common.jvm)
    implementation(libs.androidx.room.runtime.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation ("com.squareup.retrofit2:retrofit:2.11.0") // Check for the absolute latest version on Maven Central
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")


//        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
//        // For Android-specific features (e.g., Dispatchers.Main)
//        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

    //implementation ("com.github.dhaval2404:imagepicker:2.1")
}