package com.example.questnavigasitugas_232

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Navigasi {
    Welcome,
    Detail,
    Formulir
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    var nama by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = com.example.testnavigasi3layer.Navigasi.Welcome.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            composable(com.example.testnavigasi3layer.Navigasi.Welcome.name) {
                WelcomeScreen(
                    onSubmitClick = {
                        navController.navigate(com.example.testnavigasi3layer.Navigasi.Detail.name)
                    }
                )
            }