# Setup

The source code for Sushi, its samples, and this website is available on [GitHub](https://github.com/zomato/compose-sushi).

## Installation

Add Sushi Compose UI to your project by including the dependency in your build.gradle file:
```kotlin title="build.gradle.kts"
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.eternal.kits:sushi-compose:0.0.1")
}
```


## R8 / ProGuard

If you are using R8 the shrinking and obfuscation rules are included automatically. 