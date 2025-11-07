package com.example.questnavigasitugas_232.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.questnavigasitugas_232.Navigasi
import com.example.questnavigasitugas_232.R

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

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.tampil), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF7E57C2) // warna ungu tua sama seperti header Formulir
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFD1C4E9)) // warna latar sama seperti Formulir
                .padding(isiRuang)
                .padding(all = dimensionResource(id = R.dimen.padding_medium)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(space = dimensionResource(id = R.dimen.padding_small))
        ) {
            items.forEach { item ->
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = item.first.uppercase(),
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Text(
                        text = item.second,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Cursive,
                        fontSize = 22.sp,
                        color = Color(0xFF311B92) // teks ungu tua
                    )
                }
                HorizontalDivider(thickness = 1.dp, color = Color(0xFF7E57C2))
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                shape = RoundedCornerShape(50.dp),
                onClick = { navController?.navigate(Navigasi.Welcome.name) }
            ) {
                Text("Beranda", fontSize = 18.sp, color = Color.White)
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                shape = RoundedCornerShape(50.dp),
                onClick = { navController?.navigate(Navigasi.Formulir.name) }
            ) {
                Text("Formulir Pendaftaran", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}