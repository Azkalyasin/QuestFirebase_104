package com.example.p14.viewmodel.provider


import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import com.example.p14.repositori.AplikasiDataSiswa
import com.example.p14.viewmodel.EntryViewModel
import com.example.p14.viewmodel.HomeViewModel
import com.example.p14.viewmodel.DetailViewModel
import com.example.p14.viewmodel.EditViewModel


fun CreationExtras.aplikasiDataSiswa(): AplikasiDataSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as
            AplikasiDataSiswa)

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                aplikasiDataSiswa().container.repositorySiswa
            )
        }
        initializer {
            EntryViewModel(
                aplikasiDataSiswa().container.repositorySiswa
            )
        }
        initializer {
            DetailViewModel(
                this.createSavedStateHandle(),
                aplikasiDataSiswa().container.repositorySiswa
            )
        }
        initializer {
            EditViewModel(
                this.createSavedStateHandle(),
                aplikasiDataSiswa().container.repositorySiswa
            )
        }
    }
}
