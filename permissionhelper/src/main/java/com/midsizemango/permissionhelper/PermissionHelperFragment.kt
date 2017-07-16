package com.midsizemango.permissionhelper

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat

/**
 * Created by prasad on 7/16/17.
 */
open class PermissionHelperFragment : Fragment() {

    private val REQUEST_PERMISSION = 123
    private var permissionResult: PermissionResult? = null
    private var permissionsRequest:Array<String>? = null
    private var permissionRequestSingle:String? = null


    override fun onCreate(args: Bundle?) {
        super.onCreate(args)
        retainInstance = false
    }

    fun isPermissionGranted(context: Context, permission:String):Boolean{
        return ((Build.VERSION.SDK_INT < Build.VERSION_CODES.M) || (ContextCompat.checkSelfPermission(context,permission) == PackageManager.PERMISSION_GRANTED))
    }

    fun arePermissionsGranted(context: Context, permissions:Array<String>?):Boolean{
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return true

        var granted:Boolean = true
        for(permission in permissions!!){
            if(ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED)
                granted = false
        }
        return granted
    }

    fun requestPermissionHandler(permission:String) {
        val permissions = mutableListOf(permission)

        if (permissions.isEmpty()) {
            if (permissionResult != null) {
                permissionResult?.permissionGranted()
            }
        }else {
            requestPermissions(permissions.toTypedArray(), REQUEST_PERMISSION)
        }
    }

    fun requestPermissionsHandler(permissionRequest:Array<String>?) {
        var permissions = mutableListOf<String>()

        for (i in permissionRequest!!.indices) {
            if (!isPermissionGranted(activity,permissionRequest[i])) {
                permissions.add(permissionRequest[i])
            }
        }

        if (permissions.isEmpty()) {
            if (permissionResult != null) {
                permissionResult?.permissionGranted()
            }
        }else {
            requestPermissions(permissions.toTypedArray(), REQUEST_PERMISSION)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode != REQUEST_PERMISSION)
            return

        val permissionDenied = mutableListOf<String>()
        var granted:Boolean = true
        for(i in grantResults.indices){
            if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                granted = false
                permissionDenied.add(permissions[i])
            }
        }

        if(permissionResult != null){
            if(granted){
                (permissionResult as PermissionResult).permissionGranted()
            }else{
                for(s in permissionDenied){
                    if(!shouldShowRequestPermissionRationale(s)){
                        (permissionResult as PermissionResult).permissionDeniedPermanently()
                        return
                    }
                }
                (permissionResult as PermissionResult).permissionDenied()
            }
        }
    }

    fun requestPermissions(permissions:Array<String>?, permissionResult:PermissionResult){
        permissionsRequest = permissions
        this.permissionResult = permissionResult
        requestPermissionsHandler(permissionsRequest)
    }

    fun requestPermission(permission:String, permissionResult:PermissionResult){
        permissionRequestSingle = permission
        this.permissionResult = permissionResult
        requestPermissionHandler(permissionRequestSingle!!)
    }

    fun openSettingsPermission(context: Context){
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        intent.data = Uri.parse("package:"+context.packageName)
        startActivity(intent)
    }
}