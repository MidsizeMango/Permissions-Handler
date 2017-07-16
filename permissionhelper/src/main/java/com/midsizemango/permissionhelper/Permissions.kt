package com.midsizemango.permissionhelper

import android.Manifest

/**
 * Created by prasad on 7/16/17.
 */
object Permissions {

    val GROUP_CAMERA = Manifest.permission_group.CAMERA
    val GROUP_CONTACTS = Manifest.permission_group.CONTACTS
    val GROUP_CALENDAR = Manifest.permission_group.CALENDAR
    val GROUP_SMS = Manifest.permission_group.SMS
    val GROUP_MICROPHONE = Manifest.permission_group.MICROPHONE
    val GROUP_PHONE = Manifest.permission_group.PHONE
    val GROUP_SENSORS = Manifest.permission_group.SENSORS

    val GROUP_LOCATION = Manifest.permission_group.LOCATION
    val GROUP_STORAGE = Manifest.permission_group.STORAGE

    val CAMERA = Manifest.permission.CAMERA
    val READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE
    val WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE

    val READ_CALENDAR = Manifest.permission.READ_CALENDAR
    val WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR

    val READ_CONTACTS = Manifest.permission.READ_CONTACTS
    val WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS

    val GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS
    val ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION
    val ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION

    val READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE
    val CALL_PHONE = Manifest.permission.CALL_PHONE
    val READ_CALL_LOG = Manifest.permission.READ_CALL_LOG
    val WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG
    val ADD_VOICEMAIL = Manifest.permission.ADD_VOICEMAIL
    val USE_SIP = Manifest.permission.USE_SIP
    val PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS

    val SEND_SMS = Manifest.permission.SEND_SMS
    val RECEIVE_SMS = Manifest.permission.RECEIVE_SMS
    val READ_SMS = Manifest.permission.READ_SMS
    val RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH
    val RECEIVE_MMS = Manifest.permission.RECEIVE_MMS

    val RECORD_AUDIO = Manifest.permission.RECORD_AUDIO

    val BODY_SENSORS = Manifest.permission.BODY_SENSORS
}