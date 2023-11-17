package com.example.ucp2


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
) {
    var NamaMahasiswa by rememberSaveable { mutableStateOf("") }
    var NIM by remember { mutableStateOf("") }
    var Konsentrasi by remember { mutableStateOf("") }
    var JudulSkripsi by remember { mutableStateOf("") }
    var listData: MutableList<String> = mutableListOf(NamaMahasiswa, NIM, Konsentrasi, JudulSkripsi)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        OutlinedTextField(
            value = NamaMahasiswa,
            onValueChange = { NamaMahasiswa = it },
            label = { Text(text = "Nama Mahasiswa") })
        OutlinedTextField(
            value = NIM,
            onValueChange = { NIM = it },
            label = { Text(text = "NIM") })
        OutlinedTextField(
            value = Konsentrasi,
            onValueChange = { Konsentrasi = it },
            label = { Text(text = "Konsentrasi") })
        OutlinedTextField(
            value = JudulSkripsi,
            onValueChange = { JudulSkripsi = it },
            label = { Text(text = "Konsentrasi") })
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = { onSubmitButtonClicked(listData) }) {
            Text(text = stringResource(id = R.string.btn_submit))

        }
    }
}
@Composable
fun DosenPembimbing(
    dospem : List<String>,
    onSelectionChanged: (String) -> Unit,
    onConfirmButtonClicked: (Int) -> Unit,
    modifier: Modifier = Modifier

){
    var dospemYgDipilih by rememberSaveable {
        mutableStateOf("")
    }
    Column (modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween) {
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        ) {
            dospemYgDipilih.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = dospemYgDipilih == item,
                    onClick = {
                        dospemYgDipilih = item
                        onSelectionChanged(item)
                    }
                ),
                    verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = dospemYgDipilih == item,
                        onClick = {
                            dospemYgDipilih = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(item)
                }

            }
            Divider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(
                    bottom =
                    dimensionResource(R.dimen.padding_medium)
                )
            )
        }
    }
}




