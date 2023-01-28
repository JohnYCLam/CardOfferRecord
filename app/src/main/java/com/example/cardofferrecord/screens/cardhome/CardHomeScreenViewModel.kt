package com.example.cardofferrecord.screens.cardhome

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardofferrecord.model.CardApplicationInfo
import com.example.cardofferrecord.model.WelcomeOffer
import com.example.cardofferrecord.repository.CardOfferRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardHomeScreenViewModel @Inject constructor(private val repository: CardOfferRepository): ViewModel() {
    private val _cardApplications = MutableStateFlow<List<CardApplicationInfo>>(emptyList())
    val cardApplications = _cardApplications.asStateFlow()

    private val _welcomeOffers = MutableStateFlow<List<WelcomeOffer>>(emptyList())
    val welcomeOffers = _welcomeOffers.asStateFlow()

    init {
        getAllCardApplication()
        getAllWelcomeOffer()
    }

    private fun getAllCardApplication() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllCardApplication().distinctUntilChanged()
                .collect { listOfCardApplications ->
                    if (listOfCardApplications.isNullOrEmpty()) {
                        Log.d("Empty", "Empty List")
                    } else {
                        _cardApplications.value = listOfCardApplications
                    }
                }
        }
    }

    private fun getAllWelcomeOffer() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllWelcomeOffer().distinctUntilChanged()
                .collect { listOfWelcomeOffers ->
                    if (listOfWelcomeOffers.isNullOrEmpty()) {
                        Log.d("Empty", "Empty List")
                    } else {
                        _welcomeOffers.value = listOfWelcomeOffers
                    }
                }
        }
    }

}