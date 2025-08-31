package com.mb.juneandroidbatch

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mb.juneandroidbatch.fragment.FragmentTest
import com.mb.juneandroidbatch.recycler.NameAdapter
import com.mb.juneandroidbatch.recycler.NameItem
import com.mb.juneandroidbatch.retrofit.network.QuoteApi
import com.mb.juneandroidbatch.retrofit.network.RetrofitHelper
import com.mb.juneandroidbatch.viewpager.ViewPagers
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var nameAdapter: NameAdapter
    private val namelist = listOf(
        NameItem("John Doe"),
        NameItem("Jane Smith"),
        NameItem("Alice Johnson"),
        NameItem("Akila"),
        NameItem("vsd"),
        NameItem("svd Doe"),
        NameItem("svd Smith"),
        NameItem("vsd Johnson"),
        NameItem("svd"),
        NameItem("vs"),
        NameItem("vsdf Doe"),
        NameItem("Janevsdv Smisvdth"),
        NameItem("svd Johnson"),
        NameItem("vsd"),
        NameItem("svd")
    )
    val channelId = "mychannel_id"
    val channelName = "My Notification"

    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


//               Coroutinefun()

        val quotesApi = RetrofitHelper.getInstance().create(QuoteApi::class.java)
        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            Log.d("data", result.body().toString())
        }


        val simpleCalculator = findViewById<Button>(R.id.simple_calculator_btn)
        val bmiCalculator = findViewById<Button>(R.id.bmi_calculator_btn)
        val lifecycle = findViewById<Button>(R.id.lifecycle)
        val tictac = findViewById<Button>(R.id.tictactoe_btn)
        val frag = findViewById<Button>(R.id.frag_btn)
        val viewPager = findViewById<Button>(R.id.viewpager_btn)
        val sendbtn = findViewById<Button>(R.id.send_msg_btn)

        frag.setOnClickListener {
            replace(fragment = FragmentTest())
        }

        recyclerView = findViewById(R.id.list_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        nameAdapter = NameAdapter(namelist)
        recyclerView.adapter = nameAdapter

        createNotificationChannel()

        sendbtn.setOnClickListener {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                } else {
                    showNotification("Hello!", "This is a test notification.")
                }
            } else {
                showNotification("Hello!", "This is a test notification.")
            }



        }
//    }
//            try {
//               val email = Intent(Intent.ACTION_SEND).apply {
//                    type = "text/plain"
//                    putExtra(Intent.EXTRA_EMAIL, arrayOf("mohitbaghel66@gmail.com"))
//                   putExtra(Intent.EXTRA_SUBJECT, "This is subject")
//                   putExtra(Intent.EXTRA_TEXT, "This is email body, from android test app")
//
//               }
//
//                startActivity(Intent.createChooser(email, "Choose an Email client :"))
//
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }


        simpleCalculator.setOnClickListener {
           Intent(this,SimpleCalculator::class.java).also {
               startActivity(it)
           }
        }

        lifecycle.setOnClickListener {
            Intent(this, Lifecycle::class.java).also {
                startActivity(it)
            }
        }


        bmiCalculator.setOnClickListener {
            try {
                Intent(this, BMICalculator:: class.java).also{
                    startActivity(it)
                }
            } catch (e: Exception) {
                Log.e("MainActivity", "Error starting BMI Calculator", e)
            }

        }


        tictac.setOnClickListener {
            try {
                Intent(this, TicTacToe:: class.java).also {
                    startActivity(it)
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }


        viewPager.setOnClickListener {
            try {
                Intent(this, ViewPagers:: class.java).also {
                    startActivity(it)
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
    // Create notification channel (required for Android 8+)
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "My Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Channel for app notifications"
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showNotification(title: String, message: String) {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(this)) {
            if (ActivityCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED || Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU
            ) {
                notify(1001, builder.build())
            }
        }
    }



    private  suspend  fun Coroutinefun() {
        GlobalScope.launch {
            // todo
        }


        val deferrred =  GlobalScope.async {
            return@async 10
        }

        val result = deferrred.await()

    }

    private  suspend fun doLongRunningTask() {
        withContext(Dispatchers.Default){
            delay(2)
        }
        }


    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                showNotification("Hello!", "Permission granted! Notification shown.")
            } else {
                Toast.makeText(this, "Notification permission denied.", Toast.LENGTH_SHORT).show()
            }
        }

    private  fun replace(fragment : FragmentTest){
        val fragmentTransaction  = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_layout, fragment)
        fragmentTransaction.commit()

    }




}





// bindservice