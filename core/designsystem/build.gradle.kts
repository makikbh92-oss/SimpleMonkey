plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.mc.simplemonkey.compose.designsystem"
    compileSdk {
        version = release(37)
    }


    defaultConfig {
        minSdk = 24
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    // image loading

    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.compose.runtime)             // 추가
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.graphics)
    api(libs.androidx.compose.foundation.layout)   // 추가
    api(libs.androidx.compose.ui.tooling.preview)
}