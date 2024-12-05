package com.care

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit, onSignUp: () -> Unit) {
    val context = LocalContext.current

    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)  // Green background
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login", style = MaterialTheme.typography.headlineLarge)

        // Phone input field
        TextField(value = phone, onValueChange = { phone = it }, label = { Text("Phone") })
        Spacer(modifier = Modifier.height(8.dp))

        // Email input field
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        Spacer(modifier = Modifier.height(8.dp))

        // Password input field
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Login Button
        Button(onClick = {
            // Handle login logic
            onLoginSuccess()  // Navigate to MenuScreen
        }) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Sign Up Button
        Button(onClick = { onSignUp() }) {
            Text("Sign Up")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Social Media Buttons (Facebook and Google)
        Row {
            // Facebook Button
            Button(onClick = { openBrowser(context, "https://www.facebook.com") }) {
                Text("Facebook")
            }
            Spacer(modifier = Modifier.width(8.dp))

            // Google Button
            Button(onClick = { openBrowser(context, "https://www.google.com") }) {
                Text("Google")
            }
        }
    }
}

fun openBrowser(context: android.content.Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginScreen(onLoginSuccess = {}, onSignUp = {})
}
