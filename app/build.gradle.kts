import org.jetbrains.kotlin.storage.CacheResetOnProcessCanceled.enabled

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.jaygoo_rangeseekbar"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.jaygoo_rangeseekbar"
        minSdk = 24
        targetSdk = 34
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

    packagingOptions {
        exclude("META-INF/androidx.localbroadcastmanager_localbroadcastmanager.version")
        exclude("META-INF/androidx.appcompat_appcompat.version")
        exclude("META-INF/androidx.cursoradapter_cursoradapter.version")
        exclude("META-INF/androidx.drawerlayout_drawerlayout.version")
        exclude("META-INF/androidx.print_print.version")
        exclude("META-INF/androidx.interpolator_interpolator.version")
        exclude("META-INF/androidx.fragment_fragment.version")
        exclude("META-INF/androidx.customview_customview.version")
        exclude("META-INF/androidx.documentfile_documentfile.version")
        exclude("META-INF/androidx.vectordrawable_vectordrawable.version")
        exclude("META-INF/androidx.legacy_legacy-support-core-utils.version")
        exclude("META-INF/androidx.loader_loader.version")
        exclude("META-INF/androidx.viewpager_viewpager.version")
        exclude("META-INF/androidx.vectordrawable_vectordrawable-animated.version")
        exclude("META-INF/androidx.coordinatorlayout_coordinatorlayout.version")

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

    implementation("com.github.Jay-Goo:RangeSeekBar:3.0.0") {
        exclude("com.android.support", "support-compat")
    }
}