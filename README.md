# ElevateHealth

A modern Android health and wellness application built with MVVM architecture and Jetpack Compose.

## Architecture Overview

This app follows Clean Architecture principles with MVVM pattern:

### App Structure

```
com.wellness.elevatehealth/
├── data/                  # Data layer
│   ├── remote/            # Network API services 
│   ├── local/             # Local database and preferences
│   ├── repository/        # Repository implementations
│   └── model/             # Data models, DTOs
│
├── domain/                # Domain layer 
│   ├── model/             # Domain entities
│   ├── repository/        # Repository interfaces
│   └── usecase/           # Use cases for business logic
│
├── presentation/          # UI layer
│   ├── common/            # Shared UI components
│   ├── home/              # Home screen UI and ViewModel
│   ├── profile/           # Profile screen UI and ViewModel
│   └── navigation/        # Navigation setup
│
├── di/                    # Dependency injection modules
│
└── util/                  # Utilities and extensions
```

### Key Technologies

- **Jetpack Compose**: Modern declarative UI toolkit
- **Kotlin Coroutines & Flow**: Asynchronous programming
- **Hilt**: Dependency injection
- **Retrofit & OkHttp**: Networking
- **Room**: Local database
- **Kotlinx Serialization**: JSON parsing
- **Navigation Compose**: Navigation between screens

### MVVM Pattern Implementation

- **Model**: Data and business logic in the data and domain layers
- **View**: Composable functions that display UI and send user events to ViewModels
- **ViewModel**: Manages UI state and handles business logic by communicating with use cases

### Unidirectional Data Flow

- Data flows down from ViewModels to UI components through StateFlow
- UI events flow up from composables to ViewModels
- This creates a predictable pattern for state management and UI updates

## Building and Running

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle files
4. Run the app on an emulator or physical device

## Features (Planned)

- Health tracking
- Workout plans
- Nutrition tracking
- Sleep monitoring
- Progress visualizations