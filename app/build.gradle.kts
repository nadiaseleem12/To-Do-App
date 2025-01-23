plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt)
}

android {
    namespace = "com.route.todo"
    compileSdk = 35


    defaultConfig {
        applicationId = "com.route.todo"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        resourceConfigurations.addAll(setOf("en", "ar"))
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
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.appcompat.v161)

    implementation(libs.material.v1110)

    implementation(libs.androidx.constraintlayout.v214)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
    // Room DataBase
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
    //calendarView
    implementation(libs.material.calendarview)
    //SwipeLayout
    implementation(libs.swipelayout)

}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}
