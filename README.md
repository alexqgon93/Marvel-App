# 🤖 Marvel App APP ANDROID
## What is this repository for?

Android app repository integrates Hilt DI, Clean Architecture with MVVM, and RxJava/RxKotlin for reactive programming. This setup ensures efficient dependency management, modularity, and responsiveness in app development.

## Technology Stack

|                | **Name** | **Version** |  
|----------------|----------|-------------|  
| **Lenguage**   | Kotlin   | 1.9.0       |  
| **Build Tool** | Gradle   | 8.3.1       |  


## 🛠 Setup & Installation
* This app is and app which uses the [Marvel Developer](https://developer.marvel.com/documentation/getting_started) to be able to show trending gifs.
* To be able to execute this app it will have the necessity to create an account and obtain an API KEY.
* Finally on local.properties add this lines:
```  
public_key=<Your Public Api Key>
private_key=<Your Private Api Key>    
```  

## Libraries used on this project
- [Kotlin](https://kotlinlang.org/)
- [JetpackCompose](https://developer.android.com/jetpack/compose)
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/)
- [Material Design 3](https://developer.android.com/jetpack/compose/designsystems/material3)
- [KSP](https://github.com/google/ksp)
- [JUnit](https://developer.android.com/training/testing/local-tests)
- [Mockk](https://mockk.io)
- [Secrets Gradle Plugin for Android](https://github.com/google/secrets-gradle-plugin)