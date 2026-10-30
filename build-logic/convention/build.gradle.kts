plugins {
    `kotlin-dsl`
}

group = "com.mc.simplemonkey.compose.buildlogic"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.compose.compiler.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.kotlin.serialization.gradlePlugin)
    compileOnly(libs.hilt.gradlePlugin)   // 추가
    compileOnly(libs.ksp.gradlePlugin)    // 추가
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "mc.simplemonkey.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "mc.simplemonkey.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "mc.simplemonkey.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "mc.simplemonkey.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "mc.simplemonkey.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidHilt") {
            id = "mc.simplemonkey.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidOk") {
            id = "mc.simplemonkey.android.ok"
            implementationClass = "AndroidOkConventionPlugin"
        }
//        register("spotless") {
//            id = "skydoves.pokedex.spotless"
//            implementationClass = "SpotlessConventionPlugin"
//        }
    }
}