package com.example.android3_2.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3_2.data.models.Character
import com.example.android3_2.data.repositories.CharacterRepositories
import com.example.android3_2.utils.UiSate


class CharapterViewModel : ViewModel() {
    private val characterRepositories = CharacterRepositories()

    private val _charapterLiveData = MutableLiveData<UiSate<List<Character>>>()
    val charapterLiveData: LiveData<UiSate<List<Character>>> = _charapterLiveData

    init {
        getCharapter()
    }

    fun getCharapter() {
        android.os.Handler().postDelayed(
            {
                val character = characterRepositories.getCharacters()
                if (character.size <= 10) {
                    _charapterLiveData.value =
                        UiSate(isLoading = false, success = character)
                } else {
                    _charapterLiveData.value =
                        UiSate(isLoading = false, error = "very large amount of data")
                }

            }, 3000
        )
    }

    fun addCharapter(character: Character) {
        characterRepositories.addCharacter(character)
    }

    override fun onCleared() {
        super.onCleared()
    }
}