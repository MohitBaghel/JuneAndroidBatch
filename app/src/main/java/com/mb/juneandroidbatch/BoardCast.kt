package com.mb.juneandroidbatch

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BoardCast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "BroadCast Received", Toast.LENGTH_SHORT).show()
    }
}