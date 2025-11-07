package com.example.questnavigasitugas_232.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    nama: String,
    jenisKelamin: String,
    status: String,
    alamat: String,
    onBackBtnClick: () -> Unit,
    navController: NavController? = null
) {
    val items = listOf(
        Pair(stringResource(id = R.string.nama_lengkap), nama),
        Pair(stringResource(id = R.string.jenis_kelamin), jenisKelamin),
        Pair("STATUS PERKAWINAN", status),
        Pair(stringResource(id = R.string.alamat), alamat)
    )