package com.example.questnavigasitugas_232.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun FormulirPendaftaran(
    modifier: Modifier = Modifier,
    onSubmit: (String, String, String, String) -> Unit // nama, gender, status, alamat
) {
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val listGender = listOf("Laki-laki", "Perempuan")
    val listStatus = listOf("Janda", "Lajang", "Duda")