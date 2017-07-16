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
	 compile 'com.github.MidsizeMango:Permissions-Handler:v0.1'
}
```

### How to use

#### Activity

Activity extends PermissionHelperActivity

```Kotlin

class MainActivity : PermissionHelperActivity() {
   ...
}
```

#### Fragment

Fragment extends PermissionHelperFragment

```Kotlin

class MainFragment : PermissionHelperFragment() {
   ...
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

# Permission Requests
#### For Single Permission

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

#### For Multiple Permissions

```Kotlin
val permissions = arrayOf(Permissions.ACCESS_COARSE_LOCATION,Permissions.READ_EXTERNAL_STORAGE,
                Permissions.WRITE_EXTERNAL_STORAGE,Permissions.READ_CONTACTS)
                
requestMultiplePermissions(Permissions.ACCESS_COARSE_LOCATION, object: PermissionResult{
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


# Other Usage
#### To Check if Permission is Granted or Not

```Kotlin
val granted: Boolean = isPermissionGranted(this, Permissions.CAMERA)
```

#### To Check for Multiple Permissions are Granted or Not

```Kotlin
val permissions = arrayOf(Permissions.ACCESS_COARSE_LOCATION,Permissions.READ_EXTERNAL_STORAGE,
                Permissions.WRITE_EXTERNAL_STORAGE,Permissions.READ_CONTACTS)
val granted: Boolean = arePermissionsGranted(this, permissions)
```

#### For Settings Application Details
```Kotlin
 openSettingsPermission(applicationContext);
```

