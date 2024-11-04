package com.example.push

import android.os.Build
import android.telecom.ConnectionService
import androidx.annotation.RequiresApi
import android.telecom.Connection
import android.telecom.ConnectionRequest
import android.telecom.PhoneAccountHandle

@RequiresApi(Build.VERSION_CODES.M)
class CallkitService : ConnectionService() {

    override fun onCreateIncomingConnection(
        connectionManagerPhoneAccount: PhoneAccountHandle,
        request: ConnectionRequest
    ): Connection {
        val connection = MyConnection()
        connection.setInitializing()
        connection.setActive()
        showIncomingCallNotification(applicationContext)
        return connection
    }

    override fun onCreateOutgoingConnection(
        connectionManagerPhoneAccount: PhoneAccountHandle,
        request: ConnectionRequest
    ): Connection {
        val connection = MyConnection()
        connection.setDialing()
        connection.setActive()
        return connection
    }
}
