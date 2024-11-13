package com.app.application

import android.app.Activity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterScreen(onDismiss: () -> Unit) {
    var categoryEggs by remember { mutableStateOf(false) }
    var categoryNoodles by remember { mutableStateOf(false) }
    var categoryChips by remember { mutableStateOf(false) }
    var categoryFastFood by remember { mutableStateOf(false) }

    var brandIndividual by remember { mutableStateOf(false) }
    var brandCocola by remember { mutableStateOf(false) }
    var brandIfad by remember { mutableStateOf(false) }
    var brandKazi by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        // Close icon and title
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            val backDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

            IconButton(onClick = { backDispatcher?.onBackPressed() }) {
                Icon(Icons.Default.Clear, contentDescription = "Close")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text("Filters", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Categories section

        Spacer(modifier = Modifier.height(8.dp))
        Column(modifier = Modifier.background(Color(0xFFF7F7F7), RoundedCornerShape(16.dp)).padding(16.dp)) {
            Text("Categories", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
            FilterCheckbox("Eggs", categoryEggs) { categoryEggs = it }
            FilterCheckbox("Noodles & Pasta", categoryNoodles) { categoryNoodles = it }
            FilterCheckbox("Chips & Crisps", categoryChips) { categoryChips = it }
            FilterCheckbox("Fast Food", categoryFastFood) { categoryFastFood = it }




        // Brand section
        Text("Brand", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
        Spacer(modifier = Modifier.height(8.dp))

            FilterCheckbox("Individual Collection", brandIndividual) { brandIndividual = it }
            FilterCheckbox("Cocola", brandCocola) { brandCocola = it }
            FilterCheckbox("Ifad", brandIfad) { brandIfad = it }
            FilterCheckbox("Kazi Farms", brandKazi) { brandKazi = it }

        Spacer(modifier = Modifier.weight(1f))

        // Apply Filter button
        Button(
            onClick = { /* Apply filter action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(50.dp)
        ) {
            Text("Apply Filter", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

}

@Composable
fun FilterCheckbox(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(checkedColor = Color(0xFF4CAF50))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFilterScreen() {
    FilterScreen(onDismiss = { /* No action for preview */ })
}
