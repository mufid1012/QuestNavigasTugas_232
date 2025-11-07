package com.example.questnavigasitugas_232

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.questnavigasitugas_232.ui.theme.QuestNavigasiTugas_232Theme
import com.example.questnavigasitugas_232.DataApp   // ✅ import DataApp dari file Navigasi.kt
import com.example.questnavigasitugas_232.ui.theme.QuestNavigasiTugas_232Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestNavigasiTugas_232Theme {
                DataApp()   // ✅ tampilkan seluruh navigasi Compose kamu
            }
        }
    }
}