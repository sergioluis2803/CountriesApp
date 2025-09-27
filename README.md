🌍 CountriesAPP
Aplicación móvil desarrollada en Android Studio con Kotlin y Jetpack Compose, que permite explorar un listado de países obtenidos desde la API pública REST Countries.

La app cuenta con:
🔎 Buscador dinámico que actualiza los resultados en tiempo real.
📋 Listado de países con información básica.
📖 Pantalla de detalles con información extendida de cada país.
🎨 Interfaz construida con Jetpack Compose.

🚀 Tecnologías y herramientas
Lenguaje: Kotlin
Arquitectura: Clean Architecture (Domain, Data, UI)
UI: Jetpack Compose
Inyección de dependencias: Dagger Hilt
Consumo de API: Retrofit
Manejo de estado: ViewModel + MutableStateFlow
Pruebas: JUnit (unitarias de casos de uso y viewmodels)

📂 Estructura del proyecto
CountriesAPP/
│── app/
│   ├── data/        # Repositorios, modelos DTO, consumo de API con Retrofit
│   ├── di/          # Módulos de inyección con Dagger Hilt
│   ├── domain/      # Modelos de negocio y casos de uso
│   ├── ui/          # Pantallas y componentes con Jetpack Compose
│   │   ├── list/    # Listado de países + buscador
│   │   └── detail/  # Pantalla de detalles
│   └── utils/       # Helpers y clases de soporte
└── build.gradle

📸 Capturas de pantalla
