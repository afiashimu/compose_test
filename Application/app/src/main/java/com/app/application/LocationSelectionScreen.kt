package com.app.application

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextFieldDefaults

@Composable
fun LocationSelectionScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .background(Color.White)
            .padding(start = 10.dp)
    ) {
        // Back button
        IconButton(onClick = { /* Handle back press */ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back), // Replace with your back icon
                contentDescription = "Back"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_map), // Replace with your map icon
                contentDescription = "Map Icon",
                modifier = Modifier.size(250.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Select Your Location",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Switch on your location to stay in tune with \n what's happening in your area",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Dropdown for Zone
            DropdownExample(label = "Your zone", options = listOf("Border", "Option 2", "Option 3", "Option 4", "Option 5"))

            Spacer(modifier = Modifier.height(8.dp))

            // Dropdown for Area
            DropdownExample(label = "Your Area", options = listOf("Area 1", "Area 2", "Area 3", "Area 4", "Area 5"))

            Spacer(modifier = Modifier.height(24.dp))

            // Get Started Button
            Button(
                onClick = { /* Navigate to next screen */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)), // Replace with your GreenJC color
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 10.dp)
            ) {
                Text(text = "Submit", color = Color.White, fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.height(60.dp))
        }
    }  
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownExample(label: String, options: List<String>, initialState: Boolean = false) {
    var expanded = remember { mutableStateOf(initialState) }
    var selectedOption = remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded.value,
        onExpandedChange = { expanded.value = !expanded.value },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.White)
    ) {
        TextField(
            value = selectedOption.value,
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded.value)
            },
            colors = TextFieldDefaults.run {
                textFieldColors(
                        containerColor = Color.Transparent, // Makes the background transparent
                        focusedIndicatorColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Gray,

                    )
            },

            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        )

        ExposedDropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        selectedOption.value = selectionOption
                        expanded.value = false
                    },
                    modifier = Modifier.background(Color.White)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLocationSelectionScreen() {
    LocationSelectionScreen()
}
