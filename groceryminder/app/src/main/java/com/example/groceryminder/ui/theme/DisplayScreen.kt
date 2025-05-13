/*
// DisplayScreen.kt
package com.example.groceryminder.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.groceryminder.model.GroceryItem

@Composable
fun DisplayScreen(
    groceries: List<GroceryItem>,
    onAddMore: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Saved Groceries", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        groceries.forEach {
            Text("- ${it.name}, Qty: ${it.quantity}, Time: ${it.dateTime}, ${it.frequency}")
        }

        Spacer(modifier = Modifier.weight(1f))

        FloatingActionButton(
            onClick = onAddMore,
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Text("+")
        }
    }
}
*/

/*
package com.example.groceryminder.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.groceryminder.model.GroceryItem

@Composable
fun DisplayScreen(
    groceries: List<GroceryItem>,
    onAddMore: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddMore) {
                Text("+")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Grocery List",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Table header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Item", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)
                Text("Qty", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)
                Text("Date/Time", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)
                Text("Repeat", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)
            }

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            LazyColumn {
                items(groceries) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(item.name, modifier = Modifier.weight(1f))
                        Text(item.quantity, modifier = Modifier.weight(1f))
                        Text(item.dateTime, modifier = Modifier.weight(1f))
                        Text(item.frequency, modifier = Modifier.weight(1f))
                    }
                    Divider()
                }
            }
        }
    }
}
*/


/*
package com.example.groceryminder.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.groceryminder.model.GroceryItem

@Composable
fun DisplayScreen(groceries: List<GroceryItem>, onAddMore: () -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddMore) {
                Icon(Icons.Default.Add, contentDescription = "Add More")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Item", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
                    Text("Qty", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
                    Text("Date & Time", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
                    Text("Repeat", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(groceries) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(item.name)
                    Text(item.quantity)
                    Text(item.dateTime)
                    Text(item.frequency)
                }
            }
        }
    }
}
*/

package com.example.groceryminder.ui
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryminder.model.GroceryItem
@Composable
fun DisplayScreen(groceries: List<GroceryItem>, onAddMore: () -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddMore) {
                Icon(Icons.Default.Add, contentDescription = "Add More")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                // Title
                Text(
                    text = "GROCERY ITEMS",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                Divider(
                    color = MaterialTheme.colorScheme.primary,
                    thickness = 2.dp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Table Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Item", fontWeight = FontWeight.Bold)
                    Text("Qty", fontWeight = FontWeight.Bold)
                    Text("Date & Time", fontWeight = FontWeight.Bold)
                    Text("Repeat", fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(8.dp))
            }

            // List Items
            items(groceries) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(item.name)
                    Text(item.quantity)
                    Text(item.dateTime)
                    Text(item.frequency)
                }
            }
        }
    }
}
