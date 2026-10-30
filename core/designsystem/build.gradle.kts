plugins {
    id("mc.simplemonkey.android.library")
    id("mc.simplemonkey.android.library.compose")

}

android {
    namespace = "com.mc.simplemonkey.compose.designsystem"
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