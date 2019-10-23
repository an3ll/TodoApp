import Versions.androidEspressoCoreVersion
import Versions.androidTestRunnerVersion
import Versions.appCompatV7Version
import Versions.constraintLayoutVersion
import Versions.junitVersion
import Versions.koinVersion
import Versions.kotlinVersion

plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("kapt")
  kotlin("android.extensions")
}

android {

  viewBinding {
    isEnabled = true
  }

  compileSdkVersion(29)
  defaultConfig {
    applicationId = "se.an3ll.todoapp"
    minSdkVersion(29)
    targetSdkVersion(29)
    versionCode = 1
    versionName = "1.0"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  sourceSets {
    getByName("main") {
      java.srcDirs("src/main/kotlin")
      assets.srcDirs("src/main/assets")
    }
    getByName("test") {
      java.srcDirs("src/test/kotlin")
    }
    getByName("androidTest") {
      java.srcDirs("src/androidTest/kotlin")
    }
  }
  defaultConfig {
    javaCompileOptions {
      annotationProcessorOptions {
        arguments(mutableMapOf("room.incremental" to "true"))
      }
    }
  }
}

dependencies {

  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
  implementation("com.android.support:appcompat-v7:$appCompatV7Version")
  implementation("com.android.support.constraint:constraint-layout:$constraintLayoutVersion")

  //koin
  implementation("org.koin:koin-android:$koinVersion")
  implementation("org.koin:koin-android-viewmodel:$koinVersion")

  //androidx
  implementation("androidx.appcompat:appcompat:1.1.0")
  implementation("androidx.fragment:fragment-ktx:1.2.0-beta02")
  implementation("androidx.activity:activity-ktx:1.1.0-beta01")

  implementation("androidx.databinding:viewbinding:3.6.0-beta1")

  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0-beta01")
  implementation("androidx.lifecycle:lifecycle-extensions:2.2.0-beta01")
  implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0-beta01")


//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0-alpha05")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0-alpha05")
//    implementation("androidx.lifecycle:lifecycle-common-java8:2.2.0-alpha05")

//  kapt("androidx.lifecycle:lifecycle-compiler:2.2.0-alpha05")

//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.1")
//    implementation("androidx.room:room-runtime:2.1.0-alpha04")
//    implementation("androidx.room:room-coroutines:2.1.0-alpha04")
//    kapt("androidx.room:room-compiler:2.1.0-alpha04")
//
//    //test
  testImplementation("junit:junit:$junitVersion")
  androidTestImplementation("com.android.support.test:runner:$androidTestRunnerVersion")
  androidTestImplementation("com.android.support.test.espresso:espresso-core:$androidEspressoCoreVersion")
}
