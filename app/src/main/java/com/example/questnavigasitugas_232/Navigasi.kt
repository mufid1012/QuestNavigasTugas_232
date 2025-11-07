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
            startDestination = com.example.questnavigasitugas_232.Navigasi.Welcome.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            composable(com.example.questnavigasitugas_232.Navigasi.Welcome.name) {
                WelcomeScreen(
                    onSubmitClick = {
                        navController.navigate(com.example.questnavigasitugas_232.Navigasi.Detail.name)
                    }
                )
            }

            composable(com.example.questnavigasitugas_232.Navigasi.Formulir.name) {
                FormulirPendaftaran(
                    onSubmit = { inputNama, inputJK, inputStatus, inputAlamat ->
                        // simpan data dari form
                        nama = inputNama
                        jenisKelamin = inputJK
                        status = inputStatus
                        alamat = inputAlamat

                        // navigasi ke halaman tampil data
                        navController.navigate(com.example.questnavigasitugas_232.Navigasi.Detail.name)
                    }
                )
            }

            composable(com.example.questnavigasitugas_232.Navigasi.Detail.name) {
                TampilData(
                    nama = nama,
                    jenisKelamin = jenisKelamin,
                    status = status,
                    alamat = alamat,
                    onBackBtnClick = {
                        navController.navigate(com.example.questnavigasitugas_232.Navigasi.Formulir.name)
                    },
                    navController = navController
                )
            }
        }
    }
}
