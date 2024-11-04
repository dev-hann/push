package com.example.push

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.telecom.PhoneAccountHandle
import android.telecom.TelecomManager
import androidx.annotation.RequiresApi

class CallHelper(context: Context) {
    private val telecomManager: TelecomManager =
        context.getSystemService(Context.TELECOM_SERVICE) as TelecomManager

    @RequiresApi(Build.VERSION_CODES.M)
    fun triggerIncomingCall(phoneAccountHandle: PhoneAccountHandle) {
        val bundle = Bundle().apply {
            putParcelable(TelecomManager.EXTRA_INCOMING_CALL_ADDRESS, phoneAccountHandle)
        }
        telecomManager.addNewIncomingCall(phoneAccountHandle, bundle)
    }
}
