plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.tuempresa.liga1"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tuempresa.liga1"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // Compose
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.compose.material:material:1.5.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0")
    implementation("androidx.activity:activity-compose:1.8.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.7.0")

    // Core
    implementation("androidx.core:core-ktx:1.11.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Firebase BOM (versiones automáticas)
    implementation(platform("com.google.firebase:firebase-bom:34.6.0"))

    // Firestore
    implementation("com.google.firebase:firebase-firestore-ktx")

    // Analytics (opcional)
    implementation("com.google.firebase:firebase-analytics")
}
