package com.example.estehnavigation

import androidx.lifecycle.ViewModel
import com.example.ucp2.Data.MhsUIState
import com.example.ucp2.DosenPembimbing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat



class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(MhsUIState())
    val  stateUI: StateFlow<MhsUIState> = _stateUI.asStateFlow()

    fun setCustomersDetails(nama : String, nim: String, konsentrasi: String, judulskripsi : String){
        _stateUI .update { stateSaatIni ->
            stateSaatIni.copy(
                NamaMahasiswa =  nama,
                NIM = nim,
                Konsentrasi = konsentrasi,
                JudulSkripsi = judulskripsi
            )
        }
    }

    fun setDospem(dospemPilihan : String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(dospem = dospemPilihan)
        }
    }


    fun setContact(listData:MutableList<String>){
        _stateUI.value = MhsUIState(
            NamaMahasiswa = listData[0],
            NIM = listData[1],
            Konsentrasi = listData[2],
            JudulSkripsi = listData[3]
        )
    }

}
