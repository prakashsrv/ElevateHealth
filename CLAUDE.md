# ElevateHealth Android Project Guidelines

## Build & Test Commands
- Build: `./gradlew build`
- Run: `./gradlew installDebug`
- Test: `./gradlew test`
- Single unit test: `./gradlew test --tests "com.wellness.elevatehealth.TestClass.testMethod"`
- Instrumented test: `./gradlew connectedAndroidTest`
- Lint: `./gradlew lint`
- Clean: `./gradlew clean`

## Code Style Guidelines
- **Kotlin**: Follow Kotlin coding conventions with trailing commas
- **Imports**: Group by package, no wildcard imports
- **Formatting**: 4-space indentation, 120 max line length
- **Naming**: CamelCase for classes, lowerCamelCase for variables/functions, UPPER_SNAKE for constants
- **Compose**: Use @Composable functions with preview when applicable
- **Types**: Explicit type declarations for public APIs, inferred for local variables
- **Architecture**: Follow MVVM with clean architecture principles
- **Error Handling**: Use sealed classes for results, avoid raw exceptions in business logic
- **Comments**: Meaningful doc comments on public functions, classes, and non-obvious code