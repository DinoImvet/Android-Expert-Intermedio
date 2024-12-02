plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
    id ("androidx.navigation.safeargs.kotlin")

}
//En caso de error de android studio prueba con cambiar el valor a compileSdk = 35
android {
    namespace = "com.aristidevs.horoscapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.aristidevs.horoscapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            resValue("string", "arisname", "HoroscApp")

            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }
        getByName("debug"){
            isDebuggable = true
            resValue("string", "arisname", "[DEBUG] HoroscApp")

            buildConfigField("String", "BASE_URL", "\"https://newastro-debug.vercel.app/\"")
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
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    /*Librerías de Navigation Component que se implementaron en libs.versions.toml

        navigation-fragment-ktx = { group = "androidx.navigation", name = "navigation-fragment-ktx", version.ref = "navVersion" }
        navigation-ui-ktx = { group = "androidx.navigation", name = "navigation-ui-ktx", version.ref = "navVersion" }
    */
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)

    //DaggerHilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //Implementamos la libreria de retrofit y la libreria de converter gson
    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation (libs.logging.interceptor)

    //Camera X
    implementation (libs.androidx.camera.core)
    implementation (libs.androidx.camera.camera2)
    implementation (libs.androidx.camera.lifecycle)
    implementation (libs.androidx.camera.view)
    implementation (libs.androidx.camera.extensions)


}