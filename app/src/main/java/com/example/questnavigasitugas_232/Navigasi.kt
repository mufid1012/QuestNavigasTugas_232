package com.example.questnavigasitugas_232

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasitugas_232.view.*
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
            startDestination = Navigasi.Welcome.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            composable(Navigasi.Welcome.name) {
                WelcomeScreen(
                    onSubmitClick = {
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }

            composable(Navigasi.Formulir.name) {
                FormulirPendaftaran(
                    onSubmit = { inputNama, inputJK, inputStatus, inputAlamat ->
                        // simpan data dari form
                        nama = inputNama
                        jenisKelamin = inputJK
                        status = inputStatus
                        alamat = inputAlamat

                        // navigasi ke halaman tampil data
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }

            composable(Navigasi.Detail.name) {
                TampilData(
                    nama = nama,
                    jenisKelamin = jenisKelamin,
                    status = status,
                    alamat = alamat,
                    onBackBtnClick = {
                        navController.navigate(Navigasi.Formulir.name)
                    },
                    navController = navController
                )
            }
        }
    }
}