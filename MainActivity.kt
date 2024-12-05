package com.care

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.care.ui.theme.CareAppTheme

class MainActivity : ComponentActivity() {
    private var currentScreen by mutableStateOf("register")  // Start with the Register screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Switch between screens based on currentScreen state
            when (currentScreen) {
                "register" -> RegisterScreen(
                    onRegisterSuccess = {
                        currentScreen = "login" // Navigate to Login after registration
                    },
                    onSignIn = {
                        currentScreen = "login" // Navigate to Login when "Sign In" is clicked
                    }
                )

                "login" -> LoginScreen(
                    onLoginSuccess = { currentScreen = "menu" },  // Navigate to Menu after login
                    onSignUp = { currentScreen = "register" }  // Navigate to Register screen
                )

                "menu" -> MenuScreen(
                    onNavigate = { screen ->
                        currentScreen = screen // Navigate based on button click
                    }
                )

                "home" -> HomeContent(onBack = { currentScreen = "menu" })
                "services" -> ServicesContent(onBack = { currentScreen = "menu" })
                "diseases" -> DiseasesContent(onBack = { currentScreen = "menu" })
                "learning" -> LearningContent(onBack = { currentScreen = "menu" })
                "health_records" -> HealthRecordsContent(onBack = { currentScreen = "menu" })
                "doctors_directory" -> DoctorsDirectoryContent(onBack = { currentScreen = "menu" })
                "contact_us" -> ContactUsContent(onBack = { currentScreen = "menu" })
            }
        }
    }
}
