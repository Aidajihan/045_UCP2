package com.example.ucp2


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MahasiswaDetailsScreen(
    onConfirmButtonClicked: (String, String,String)-> Unit,
    onCancelButtonClicked: () -> Unit
){
    var NamaMahasiswa by remember{ mutableStateOf("") }
    var NIM by remember{ mutableStateOf("") }
    var Konsentrasi by remember{ mutableStateOf("") }
    var JudulSkripsi by remember{ mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ){
        OutlinedTextField(
            value = NamaMahasiswa,
            onValueChange = {NamaMahasiswa = it},
            label = {Text(text = " Nama Mahasiswa")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
        )
        OutlinedTextField(
            value = NIM,
            onValueChange = {NIM = it},
            label = { Text(text = "NIM")},
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
        )
        OutlinedTextField(
            value = Konsentrasi,
            onValueChange ={ Konsentrasi = it},
            label = { Text(text = " Konsentrasi ")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
        )
        OutlinedTextField(
            value = JudulSkripsi,
            onValueChange ={ JudulSkripsi = it},
            label = { Text(text = "Judul Skripsi")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(onClick = onCancelButtonClicked) {
                Text(text = "Back")
            }

            Button(
                onClick = {
                    if (NamaMahasiswa.isNotEmpty() && NIM.isNotEmpty() && Konsentrasi.isNotEmpty() && JudulSkripsi.isNotEmpty()){
                        onConfirmButtonClicked(NamaMahasiswa, NIM, Konsentrasi, JudulSkripsi)
                    }
                }
            ) {
            }
        }
    }
}

