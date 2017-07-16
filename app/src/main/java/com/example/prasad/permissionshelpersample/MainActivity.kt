package com.example.prasad.permissionshelpersample

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.midsizemango.permissionhelper.PermissionHelperActivity
import com.midsizemango.permissionhelper.Permissions
import com.midsizemango.permissionhelper.PermissionResult


class MainActivity : PermissionHelperActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkButton = findViewById(R.id.check_button) as Button
        checkButton.setOnClickListener {
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
        }

        val permissions = arrayOf(Permissions.ACCESS_COARSE_LOCATION,Permissions.READ_EXTERNAL_STORAGE,
                Permissions.WRITE_EXTERNAL_STORAGE,Permissions.READ_CONTACTS)

        requestMultiplePermissions(permissions, object: PermissionResult {
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


    }

    fun Activity.toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
