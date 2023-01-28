package com.example.cardofferrecord.screens.cardadd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardofferrecord.model.CardApplicationInfo
import com.example.cardofferrecord.model.WelcomeOffer
import com.example.cardofferrecord.repository.CardOfferRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardAddScreenViewModel @Inject constructor(private val repository: CardOfferRepository): ViewModel() {

    fun addCardApplication(cardApplicationInfo: CardApplicationInfo) = viewModelScope.launch { repository.addCardApplication(cardApplicationInfo) }
    fun addWelcomeOffer(welcomeOffer: WelcomeOffer) = viewModelScope.launch { repository.addWelcomeOffer(welcomeOffer) }

}