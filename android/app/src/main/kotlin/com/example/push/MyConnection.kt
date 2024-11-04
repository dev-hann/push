package com.example.push

import android.os.Build
import android.telecom.Connection
import android.telecom.DisconnectCause
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.M)
class MyConnection : Connection(){
    override fun onAnswer() {
        setActive()
    }

    override fun onDisconnect() {
        setDisconnected(DisconnectCause(DisconnectCause.LOCAL))
        destroy()
    }

    override fun onReject() {
        setDisconnected(DisconnectCause(DisconnectCause.REJECTED))
        destroy()
    }
}