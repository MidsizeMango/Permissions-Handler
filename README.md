# Permissions Handler
Simple Module to simplify Android Runtime Permissions Integration in App. Written in Kotlin.

[![](https://jitpack.io/v/MidsizeMango/Permissions-Handler.svg)](https://jitpack.io/#MidsizeMango/Permissions-Handler)
### Import

in build.gradle

```
allprojects {
   repositories {
   ...
   maven { url 'https://jitpack.io' }
   }
}
```
```Gradle
dependencies {
    compile 'com.github.MidsizeMango:Permissions-Handler:-SNAPSHOT'
}
```

### How to use

#### Activity

Activity extends PermissionHelperActivity

```Kotlin

public class MainActivity extends PermissionHelperActivity {

}
```

Usage of Requesting Permission in Activity

```Kotlin
requestPermission(Permissions.CAMERA, object: PermissionResult{
       override fun permissionGranted() {
             toast("Permissions Granted")
       }

       override fun permissionDenied() {
             toast("Permissions Denied")
       }

       override fun permissionDeniedPermanently() {
             //openSettingsPermission(applicationContext)
             toast("Allow Permissions from App Settings")
       }
})
```

#### Fragment

Fragment extends PermissionHelperFragment

```Kotlin

public class MainFragment extends PermissionHelperFragment {

}
```

Usage of Requesting Permission in Fragment

```Kotlin
requestPermission(Permissions.ACCESS_COARSE_LOCATION, object: PermissionResult{
       override fun permissionGranted() {
             toast("Permissions Granted")
       }

       override fun permissionDenied() {
             toast("Permissions Denied")
       }

       override fun permissionDeniedPermanently() {
             //openSettingsPermission(applicationContext)
             toast("Allow Permissions from App Settings")
       }
})
```
