package com.midsizemango.permissionhelper

/**
 * Created by prasad on 7/16/17.
 */
interface PermissionResult {
    fun permissionGranted()
    fun permissionDenied()
    fun permissionDeniedPermanently()
}