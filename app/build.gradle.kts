plugins {
    // Plugins necesarios para indicarle a Android que compile una aplicación móvil usando Kotlin con soporte nativo de Compose
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.laboratoriowidgets"

    // Configuración del SDK del sistema operativo Android para el cual se compila la app
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.laboratoriowidgets"
        minSdk = 26 // Asegura compatibilidad total con las funciones nativas de Widgets avanzados
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

    // Configuración obligatoria para que el código de Java coincida con el motor interno de Kotlin
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        // Activa el motor gráfico de Jetpack Compose
        compose = true
    }
}

// ESTA ES LA FORMA MODERNA QUE REEMPLAZA A KOTLINOPTIONS
// Configura las opciones del compilador de Kotlin para usar Java 11 de manera uniforme
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
    }
}

dependencies {
    // Librerías base generadas de forma automática por la plantilla de Android Studio
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    // Herramientas para pruebas unitarias de software
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // ---- LIBRERÍAS DE ACCESO PARA WIDGETS CON JETPACK GLANCE ----
    // Provee el soporte estructural básico para construir y actualizar AppWidgets en el celular
    implementation("androidx.glance:glance-appwidget:1.1.0")
    // Permite utilizar los colores y formas estandarizadas del sistema de diseño Material 3
    implementation("androidx.glance:glance-material3:1.1.0")
    // Provee interoperabilidad con los componentes visuales clásicos de Material Design
    implementation("androidx.glance:glance-material:1.1.0")
}