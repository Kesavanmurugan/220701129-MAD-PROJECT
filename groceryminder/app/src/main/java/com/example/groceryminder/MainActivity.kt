

/*
package com.example.groceryminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.groceryminder.model.GroceryItem
import com.example.groceryminder.ui.DisplayScreen
import com.example.groceryminder.ui.Homescreen
import com.example.groceryminder.ui.theme.GroceryMinderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroceryMinderTheme {
                val navController = rememberNavController()
                val groceries = remember { mutableStateListOf<GroceryItem>() }

                Scaffold { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") {
                            Homescreen(
                                onSave = { groceries.add(it) },
                                onShowGroceries = { navController.navigate("display") }
                            )
                        }
                        composable("display") {
                            DisplayScreen(
                                groceries = groceries,
                                onAddMore = { navController.navigate("home") }
                            )
                        }
                    }
                }
            }
        }
    }
}
*/


/*
package com.example.groceryminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.groceryminder.model.GroceryItem
import com.example.groceryminder.ui.DisplayScreen
import com.example.groceryminder.ui.Homescreen
import com.example.groceryminder.ui.LoginScreen
import com.example.groceryminder.ui.theme.GroceryMinderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createNotificationChannel(this)

        setContent {
            GroceryMinderTheme {
                val navController = rememberNavController()
                val groceries = remember { mutableStateListOf<GroceryItem>() }

                Scaffold { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "login", // Start with Login screen
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("login") {
                            LoginScreen(navController = navController)
                        }
                        composable("home") {
                            Homescreen(
                                onSave = { groceries.add(it) },
                                onShowGroceries = { navController.navigate("display") }
                            )
                        }
                        composable("display") {
                            DisplayScreen(
                                groceries = groceries,
                                onAddMore = { navController.navigate("home") }
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun createNotificationChannel(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            "grocery_channel",
            "Grocery Reminders",
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            description = "Channel for grocery reminder notifications"
        }
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
    }
   }
*/



package com.example.groceryminder

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.groceryminder.model.GroceryItem
import com.example.groceryminder.ui.DisplayScreen
import com.example.groceryminder.ui.Homescreen
import com.example.groceryminder.ui.LoginScreen
import com.example.groceryminder.ui.theme.GroceryMinderTheme

import android.content.pm.PackageManager
import android.telephony.SmsManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createNotificationChannel(this)

        setContent {
            GroceryMinderTheme {
                val navController = rememberNavController()
                val groceries = remember { mutableStateListOf<GroceryItem>() }

                Scaffold { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("login") {
                            LoginScreen(navController = navController)
                        }
                        composable("home") {
                            Homescreen(
                                onSave = { groceries.add(it) },
                                onShowGroceries = { navController.navigate("display") }
                            )
                        }
                        composable("display") {
                            DisplayScreen(
                                groceries = groceries,
                                onAddMore = { navController.navigate("home") }
                            )
                        }
                    }
                }
            }
        }
    }

    private fun sendSMS(context: Context, phoneNumber: String, message: String) {
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.SEND_SMS)
            != PackageManager.PERMISSION_GRANTED) {
            // Request permission if not granted
            ActivityCompat.requestPermissions(
                this, // 'this' is MainActivity
                arrayOf(android.Manifest.permission.SEND_SMS),
                1
            )
        } else {
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNumber, null, message, null, null)
        }
    }

    // 👇 Inside MainActivity
    private fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "grocery_channel",
                "Grocery Reminders",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Channel for grocery reminder notifications"
            }
            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}

