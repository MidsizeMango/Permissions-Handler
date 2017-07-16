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

# License

The MIT License (MIT)

Copyright (c) 2017 MidsizeMango

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
