# Compose Sushi 🍣

Sushi Design System for Compose Multiplatform - A comprehensive design system built for Android,
iOS, Desktop and Web platforms.

## 🏗️ Project Structure

- **`sushi/sushi-core`** - Core classes used by the Sushi
- **`sushi/sushi-compose`** - Compose implementation of the Sushi design system
- **`app/`** - Sample Android/iOS application demonstrating the components
- **`website/`** - WASM/JS web application for the documentation
- **`docs/`** - Documentation and component previews

## 📋 Prerequisites

- **Java 17** or higher
- **Android Studio** (for Android development)
- **Xcode 15+** (for iOS development)
- **Node.js** (for web development)

## 🔧 Building the Project

### Build Sushi Libraries

```bash
# Assemble
./gradlew :sushi-compose:assemble

# Publish to local Maven repository
./gradlew :sushi-core:publishToMavenLocal :sushi-compose:publishToMavenLocal
```

## 📱 Running Sample Applications

### Android Sample App

```bash
# Install and run on connected device/emulator
./gradlew :app:installDebug

# Build APK
./gradlew :app:assembleDebug
```

Or open the project in Android Studio and run the `app` configuration.

### iOS Sample App

#### Prerequisites

- macOS with Xcode 15+
- iOS Simulator or physical iOS device

#### Steps

1. **Generate iOS framework:**
   ```bash
   ./gradlew :app:embedAndSignAppleFrameworkForXcode
   ```

2. **Run from Android Studio:**
   - Setup iPhone Simulator and open project in Android Studio.
   - Select sample app from run configuration
   - Select iPhone from Available Devices
   - Run app

3.  **Run from Xcode:**
   ```bash
   # Open Xcode project
   open iosApp/iosApp.xcodeproj
   ```
   - Select your target device/simulator
   - Press `Cmd + R` or click the Run button
    

#### Alternative: Command Line

```bash
# Build iOS app
./gradlew :app:iosX64MainKlibrary
# or for ARM64
./gradlew :app:iosArm64MainKlibrary
```

## 🌐 Running WASM Website

### Development Server

```bash
# Start WASM development server
./gradlew :website:wasmJsBrowserDevelopmentRun

# Alternative: JS version
./gradlew :website:jsBrowserDevelopmentRun
```

The website will be available at `http://localhost:8080`

### Production Build

```bash
# Build WASM production bundle
./gradlew :website:wasmJsBrowserDistribution

# Build JS production bundle  
./gradlew :website:jsBrowserDistribution
```

Built files will be available in:

- WASM: `website/build/dist/wasmJs/productionExecutable/`
- JS: `website/build/dist/js/productionExecutable/`

### Desktop Application (Bonus)

```bash

# Run website's desktop version (java)
./gradlew :website:run
./gradlew :website:runHot # Hot Reload

# Run website's desktop version (Native App)
./gradlew :website:runDistributable

# Create website's desktop version (Native App)
./gradlew :website:createDistributable
```

## 🧪 Testing

```bash
# Run all tests
./gradlew test

# Run specific module tests
./gradlew :sushi-core:test
./gradlew :sushi-compose:test
./gradlew :app:testDebugUnitTest
```

## 📚 Documentation

### Generate Documentation

```bash
# Generate API documentation
./gradlew dokkaHtmlMultiModule

# Build MkDocs documentation (if available)
mkdocs build
```

## 🔄 Development Workflow

### Local Development

1. **Make changes** to sushi libraries
2. **Publish locally:**
   ```bash
   ./localPublish.sh
   ```
3. **Test in sample apps** by running Android/iOS apps or website

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test on all platforms
5. Submit a pull request

## 📄 License
```
© 2025 Eternal Ltd.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
