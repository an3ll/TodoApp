buildscript {
  repositories {
    google()
    jcenter()

  }
  dependencies {
    classpath("com.android.tools.build:gradle:3.6.0-beta01")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.50")
  }
}

allprojects {
  repositories {
    google()
    jcenter()
  }
}

tasks {
  val clean by creating(Delete::class.java) {
    delete = setOf(rootProject.buildDir)
  }
}
