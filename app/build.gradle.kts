plugins {
    alias(libs.plugins.androidApplication)

}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Add the new dependencies
    implementation("androidx.recyclerview:recyclerview:1.3.0") // RecyclerView
    implementation("androidx.room:room-runtime:2.5.0") // Room
    annotationProcessor("androidx.room:room-compiler:2.5.0") // Room Compiler
    implementation("androidx.sqlite:sqlite:2.2.0") // SQLite
    implementation("androidx.sqlite:sqlite-ktx:2.2.0") // SQLite KTX
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1") // ViewModel KTX
    implementation("androidx.recyclerview:recyclerview:1.2.1") // RecyclerView (optional if you already added it above)

    implementation ("androidx.activity:activity-compose:1.6.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0")
    implementation ("androidx.compose.material3:material3:1.0.0")

    implementation ("androidx.activity:activity-ktx:1.6.1") // برای viewModels
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1") // برای LiveData
    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
