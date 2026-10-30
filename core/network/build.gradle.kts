plugins {

    id("mc.simplemonkey.android.library")
    id("mc.simplemonkey.android.hilt")
    id("mc.simplemonkey.android.ok")


}

android {
    namespace = "com.mc.simplemonkey.core.network"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.hilt.core)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)
    ksp(libs.hilt.compiler)
}