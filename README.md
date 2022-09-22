# MVVM Example

## Estructura de base

1) Añadir dependencias:
    1) View Model https://developer.android.com/jetpack/androidx/releases/lifecycle#version_24_2
    2) Koin: https://insert-koin.io/docs/setup/v3.2 (buscar la última)
2) Preparar Scaffolding
    1) Carpeta presentation
    2) Carpeta data
3) Preparar inyección de dependencias:
    1) Application. Una clase que extienda de android.app.Application
    2) Module
    3) Inicializar el module dentro del onCreate del Application
    4) [Configurar al Manifest](#configurar-manifest) para que use el Application
4) Bindear live data del View Model al
   Activity: https://developer.android.com/topic/libraries/architecture/livedata

### Configurar Manifest

En el archivo AndroidManifest.xml agrego android:name=".MainApplication" dentro
de <application></application>

## Consumo de API

### 1) Incorporar Picasso

Dependencia:

```gradle
// Module's build.gradle file
depdendencies {
    // Other dependencies
    // noinspection GradleDependency
    implementation 'com.squareup.picasso:picasso:2.8'
}
```

Uso:

```kotlin
Picasso.get().load(newURI).into(imageView)
```

### 2) Incorporar GSON

Dependencia

```gradle
// Module's build.gradle file

def retrofit_version = '2.9.0'

depdendencies {
    // Other dependencies
    // noinspection GradleDependency
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
}
```

### 3) Incorporar retrofit

