/*package com.example.groceryminder.ui.theme

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign // <-- Correct import
import java.util.*

@Composable
fun Homescreen() {
    val context = LocalContext.current
    var itemName by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var dateTime by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("Everyday") }

    val calendar = Calendar.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = "Welcome to Grocery Minder!",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp),
            textAlign = TextAlign.Center // <-- Proper usage
        )

        OutlinedTextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Item Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Quantity") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                DatePickerDialog(
                    context,
                    { _, year, month, day ->
                        TimePickerDialog(
                            context,
                            { _, hour, minute ->
                                dateTime = "$day/${month + 1}/$year $hour:$minute"
                            },
                            calendar.get(Calendar.HOUR_OF_DAY),
                            calendar.get(Calendar.MINUTE),
                            true
                        ).show()
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Select Date & Time")
        }

        Text("Selected: $dateTime")

        DropdownMenuBox(
            selected = frequency,
            onSelectedChange = { frequency = it },
            options = listOf("Everyday", "Weekly", "Monthly", "Half Yearly", "Yearly"),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "Saved: $itemName, $quantity, $dateTime, $frequency",
                    Toast.LENGTH_LONG
                ).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save")
        }
    }
}

@Composable
fun DropdownMenuBox(
    selected: String,
    onSelectedChange: (String) -> Unit,
    options: List<String>,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedTextField(
            value = selected,
            onValueChange = {},
            readOnly = true,
            label = { Text("Repeat Frequency") },
            modifier = modifier.clickable { expanded = true }
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSelectedChange(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
*/


/*
package com.example.groceryminder.ui.theme

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import java.util.*

@Composable
fun Homescreen() {
    val context = LocalContext.current
    var itemName by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var dateTime by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("Everyday") }

    val calendar = Calendar.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Spacer to push the "Welcome" text down
        Spacer(modifier = Modifier.height(40.dp)) // Adjust this value for more/less space

        // Title
        Text(
            text = "Welcome to Grocery Minder!",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        // Spacer to create some space between the "Welcome" text and the input fields
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Item Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Quantity") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                DatePickerDialog(
                    context,
                    { _, year, month, day ->
                        TimePickerDialog(
                            context,
                            { _, hour, minute ->
                                dateTime = "$day/${month + 1}/$year $hour:$minute"
                            },
                            calendar.get(Calendar.HOUR_OF_DAY),
                            calendar.get(Calendar.MINUTE),
                            true
                        ).show()
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Select Date & Time")
        }

        Text("Selected: $dateTime")

        DropdownMenuBox(
            selected = frequency,
            onSelectedChange = { frequency = it },
            options = listOf("Everyday", "Weekly", "Monthly", "Half Yearly", "Yearly"),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "Saved: $itemName, $quantity, $dateTime, $frequency",
                    Toast.LENGTH_LONG
                ).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save")
        }
    }
}

@Composable
fun DropdownMenuBox(
    selected: String,
    onSelectedChange: (String) -> Unit,
    options: List<String>,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedTextField(
            value = selected,
            onValueChange = {},
            readOnly = true,
            label = { Text("Repeat Frequency") },
            modifier = modifier.clickable { expanded = true }
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSelectedChange(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
*/

/*
package com.example.groceryminder.ui.theme

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import java.util.*

@Composable
fun Homescreen() {
    val context = LocalContext.current
    var itemName by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var dateTime by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("Everyday") }

    val calendar = Calendar.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = "WELCOME TO GROCERY MINDER",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center
        )

        // Item Name
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "ITEM NAME",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )
            OutlinedTextField(
                value = itemName,
                onValueChange = { itemName = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Enter item name") }
            )
        }

        // Quantity
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "QUANTITY",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )
            OutlinedTextField(
                value = quantity,
                onValueChange = { quantity = it },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholder = { Text("Enter quantity") }
            )
        }

        // Date & Time
        Button(
            onClick = {
                DatePickerDialog(
                    context,
                    { _, year, month, day ->
                        TimePickerDialog(
                            context,
                            { _, hour, minute ->
                                dateTime = "$day/${month + 1}/$year $hour:$minute"
                            },
                            calendar.get(Calendar.HOUR_OF_DAY),
                            calendar.get(Calendar.MINUTE),
                            true
                        ).show()
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Select Date & Time")
        }

        Text("Selected: $dateTime")

        // Repeat Frequency
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "REPEAT",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )
            DropdownMenuBox(
                selected = frequency,
                onSelectedChange = { frequency = it },
                options = listOf("Everyday", "Weekly", "Monthly", "Half Yearly", "Yearly"),
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Save Button
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "Saved: $itemName, $quantity, $dateTime, $frequency",
                    Toast.LENGTH_LONG
                ).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save")
        }

        Button(
            onClick = {
                Toast.makeText(context, "Showing all groceries...", Toast.LENGTH_SHORT).show()
                // Navigate to grocery list screen or show a dialog, etc.
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show Groceries")
        }

    }
}

@Composable
fun DropdownMenuBox(
    selected: String,
    onSelectedChange: (String) -> Unit,
    options: List<String>,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedTextField(
            value = selected,
            onValueChange = {},
            readOnly = true,
            label = { Text("Repeat Frequency") },
            modifier = modifier.clickable { expanded = true }
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSelectedChange(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
*/


/*
// Homescreen.kt
package com.example.groceryminder.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.groceryminder.model.GroceryItem
import java.util.*

@Composable
fun Homescreen(
    onSave: (GroceryItem) -> Unit,
    onShowGroceries: () -> Unit
) {
    val context = LocalContext.current
    var itemName by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var dateTime by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("Everyday") }

    val calendar = Calendar.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("WELCOME TO GROCERY MINDER", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Item Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Quantity") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            DatePickerDialog(
                context,
                { _, year, month, day ->
                    TimePickerDialog(
                        context,
                        { _, hour, minute ->
                            dateTime = "$day/${month + 1}/$year $hour:$minute"
                        },
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        true
                    ).show()
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Select Date & Time")
        }

        Text("Selected: $dateTime")

        DropdownMenuBox(
            selected = frequency,
            onSelectedChange = { frequency = it },
            options = listOf("Everyday", "Weekly", "Monthly", "Half Yearly", "Yearly"),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val item = GroceryItem(itemName, quantity, dateTime, frequency)
                onSave(item)
                Toast.makeText(context, "Saved!", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save")
        }

        Button(
            onClick = onShowGroceries,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show Groceries")
        }
    }
}

@Composable
fun DropdownMenuBox(
    selected: String,
    onSelectedChange: (String) -> Unit,
    options: List<String>,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedTextField(
            value = selected,
            onValueChange = {},
            readOnly = true,
            label = { Text("Repeat Frequency") },
            modifier = modifier.clickable { expanded = true }
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSelectedChange(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

annotation class Homescreen
*/



/*

package com.example.groceryminder.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.groceryminder.model.GroceryItem
import java.util.*

@Composable
fun Homescreen(
    onSave: (GroceryItem) -> Unit,
    onShowGroceries: () -> Unit
) {
    val context = LocalContext.current
    var itemName by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var dateTime by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("Everyday") }
    val calendar = Calendar.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "WELCOME TO GROCERY MINDER",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center
        )

        OutlinedTextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Item Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Quantity") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            DatePickerDialog(context, { _, year, month, day ->
                TimePickerDialog(context, { _, hour, minute ->
                    dateTime = "$day/${month + 1}/$year $hour:$minute"
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Select Date & Time")
        }

        Text("Selected: $dateTime")

        DropdownMenuBox(
            selected = frequency,
            onSelectedChange = { frequency = it },
            options = listOf("Everyday", "Weekly", "Monthly", "Half Yearly", "Yearly"),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (itemName.isNotBlank() && quantity.isNotBlank() && dateTime.isNotBlank()) {
                    onSave(GroceryItem(itemName, quantity, dateTime, frequency))
                    Toast.makeText(context, "Saved!", Toast.LENGTH_SHORT).show()
                    itemName = ""
                    quantity = ""
                    dateTime = ""
                    frequency = "Everyday"
                } else {
                    Toast.makeText(context, "Please fill all fields!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save")
        }

        Button(
            onClick = onShowGroceries,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show Groceries")
        }
    }
}



@Composable
fun DropdownMenuBox(
    selected: String,
    onSelectedChange: (String) -> Unit,
    options: List<String>,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier) {
        OutlinedTextField(
            value = selected,
            onValueChange = {},
            readOnly = true,
            label = { Text("Repeat Frequency") },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSelectedChange(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
*/


/*
package com.example.groceryminder.ui

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.groceryminder.ReminderReceiver
import com.example.groceryminder.model.GroceryItem
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun Homescreen(
    onSave: (GroceryItem) -> Unit,
    onShowGroceries: () -> Unit
) {
    val context = LocalContext.current
    var itemName by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var dateTime by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("Everyday") }
    val calendar = Calendar.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "WELCOME TO GROCERY MINDER",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center
        )

        OutlinedTextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Item Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Quantity") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                DatePickerDialog(context, { _, year, month, day ->
                    TimePickerDialog(context, { _, hour, minute ->
                        dateTime = "$day/${month + 1}/$year $hour:$minute"
                    }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Select Date & Time")
        }

        Text("Selected: $dateTime")

        DropdownMenuBox(
            selected = frequency,
            onSelectedChange = { frequency = it },
            options = listOf("Everyday", "Weekly", "Monthly", "Half Yearly", "Yearly"),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (itemName.isNotBlank() && quantity.isNotBlank() && dateTime.isNotBlank()) {
                    onSave(GroceryItem(itemName, quantity, dateTime, frequency))
                    Toast.makeText(context, "Saved!", Toast.LENGTH_SHORT).show()

                    // Schedule the notification
                    scheduleNotification(context, itemName, dateTime)

                    // Clear fields
                    itemName = ""
                    quantity = ""
                    dateTime = ""
                    frequency = "Everyday"
                } else {
                    Toast.makeText(context, "Please fill all fields!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save")
        }

        Button(
            onClick = onShowGroceries,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show Groceries")
        }
    }
}

// Function to schedule notification
private fun scheduleNotification(context: Context, itemName: String, dateTime: String) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
    val intent = Intent(context, ReminderReceiver::class.java).apply {
        putExtra("ITEM_NAME", itemName)
    }
    val pendingIntent = PendingIntent.getBroadcast(
        context,
        System.currentTimeMillis().toInt(),
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
    val triggerTime = sdf.parse(dateTime)?.time ?: System.currentTimeMillis()

    if (alarmManager != null && triggerTime > System.currentTimeMillis()) {
        alarmManager.setExact(
            AlarmManager.RTC_WAKEUP,
            triggerTime,
            pendingIntent
        )
    }
}

@Composable
fun DropdownMenuBox(
    selected: String,
    onSelectedChange: (String) -> Unit,
    options: List<String>,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier) {
        OutlinedTextField(
            value = selected,
            onValueChange = {},
            readOnly = true,
            label = { Text("Repeat Frequency") },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSelectedChange(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
*/


package com.example.groceryminder.ui

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.telephony.SmsManager
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.groceryminder.ReminderReceiver
import com.example.groceryminder.model.GroceryItem
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun Homescreen(
    onSave: (GroceryItem) -> Unit,
    onShowGroceries: () -> Unit
) {
    val context = LocalContext.current
    var itemName by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var dateTime by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("Everyday") }
    val calendar = Calendar.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "WELCOME TO GROCERY MINDER",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center
        )

        OutlinedTextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Item Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Quantity") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                DatePickerDialog(context, { _, year, month, day ->
                    TimePickerDialog(context, { _, hour, minute ->
                        dateTime = "$day/${month + 1}/$year $hour:$minute"
                    }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Select Date & Time")
        }

        Text("Selected: $dateTime")

        DropdownMenuBox(
            selected = frequency,
            onSelectedChange = { frequency = it },
            options = listOf("Everyday", "Weekly", "Monthly", "Half Yearly", "Yearly"),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (itemName.isNotBlank() && quantity.isNotBlank() && dateTime.isNotBlank()) {
                    onSave(GroceryItem(itemName, quantity, dateTime, frequency))
                    Toast.makeText(context, "Saved!", Toast.LENGTH_SHORT).show()

                    // Schedule the notification
                    scheduleNotification(context, itemName, dateTime)

                    // Clear fields
                    itemName = ""
                    quantity = ""
                    dateTime = ""
                    frequency = "Everyday"
                } else {
                    Toast.makeText(context, "Please fill all fields!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save")
        }

        Button(
            onClick = onShowGroceries,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show Groceries")
        }

        Button(
            onClick = {
                if (itemName.isNotBlank() && quantity.isNotBlank() && dateTime.isNotBlank()) {
                    sendSMS(context, itemName, quantity, dateTime)
                } else {
                    Toast.makeText(context, "Please fill all fields first!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Send Reminder SMS")
        }
    }
}

private fun scheduleNotification(context: Context, itemName: String, dateTime: String) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
    val intent = Intent(context, ReminderReceiver::class.java).apply {
        putExtra("ITEM_NAME", itemName)
    }
    val pendingIntent = PendingIntent.getBroadcast(
        context,
        System.currentTimeMillis().toInt(),
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
    val triggerTime = sdf.parse(dateTime)?.time ?: System.currentTimeMillis()

    if (alarmManager != null && triggerTime > System.currentTimeMillis()) {
        alarmManager.setExact(
            AlarmManager.RTC_WAKEUP,
            triggerTime,
            pendingIntent
        )
    }
}

private fun sendSMS(context: Context, itemName: String, quantity: String, dateTime: String) {
    if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.SEND_SMS)
        != PackageManager.PERMISSION_GRANTED
    ) {
        ActivityCompat.requestPermissions(
            (context as androidx.activity.ComponentActivity),
            arrayOf(android.Manifest.permission.SEND_SMS),
            1
        )
    } else {
        val smsManager = SmsManager.getDefault()
        val phoneNumber = "6382343720" // 👉 Put your real phone number here!
        val message = "Reminder: $itemName x$quantity scheduled for $dateTime!"
        smsManager.sendTextMessage(phoneNumber, null, message, null, null)
        Toast.makeText(context, "SMS Sent!", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun DropdownMenuBox(
    selected: String,
    onSelectedChange: (String) -> Unit,
    options: List<String>,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier) {
        OutlinedTextField(
            value = selected,
            onValueChange = {},
            readOnly = true,
            label = { Text("Repeat Frequency") },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSelectedChange(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
