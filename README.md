# TestHereMapOnRN

Integrate Here Map SDK into React Native Project for test build 32-bit and 64-bit APKs

## Below is why create this project

### 1. Issue:

When install and start app-arm64-v8a-release.apk on real device, get an alert message:

Error: MISSING_LIBRARIES Native libraries missing: MAPSJNI

Native libraries missing: MAPSJNI

I created a new React Native project and integrated HERE Android SDK (PREMIUM EDITION) version 3.16 into it.:
  "dependencies": {
    "react": "16.13.1",
    "react-native": "0.63.2"
  },
Then I added these config into build.gradle to build 2 apk files:

    splits {
       abi {
           enable true
           reset()
           include 'armeabi-v7a', 'arm64-v8a'
           exclude 'x86', 'x86_64'
           universalApk false
       }
   }
    packagingOptions {
        pickFirst 'lib/armeabi-v7a/libc++_shared.so'
        pickFirst 'lib/arm64-v8a/libc++_shared.so'
        exclude 'lib/x86/libc++_shared.so'
        exclude 'lib/x86_64/libc++_shared.so'
    }
  app-armeabi-v7a-release.apk (32 bit)
  app-arm64-v8a-release.apk (64 bit)
The app-armeabi-v7a-release.apk works well, but the app-arm64-v8a-release.apk got an issue:

Native libraries missing: MAPSJNI

### 2. Here team response:

It seems the library, that is used in the project, breaks loading libc++shared.so. we set the libc++ shared.so loading before the SoLoader initialisation and the crashes stopped. Just put System.loadLibrary("c++_shared"); before SoLoader.init(this, /* native exopackage */ false); in the method MainApplication.onCreate Please check the workaround.

### 3. Result:

I have followed your guidance and modified MainApplication.java onCreate() function.

Then I built 2 APKs and got the same result:
The app-armeabi-v7a-release.apk works well, but the app-arm64-v8a-release.apk got the same issue.

I was confused that why 32-bit works well but 64-bit does not, they was built from the same source code. Looking forward to your response, thanks a lot.
