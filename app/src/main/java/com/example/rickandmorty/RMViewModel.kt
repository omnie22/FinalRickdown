package com.example.rickandmorty

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.model.CharacterListModel
import com.example.rickandmorty.model.RMCharacter
import com.example.rickandmorty.remote.RMRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log

class RMViewModel : ViewModel() {
    private val _characters = MutableLiveData<CharacterListModel>()
    val characters: LiveData<CharacterListModel> get() =_characters
    private val _characterDetail = MutableLiveData<RMCharacter>()
    val characterDetail: LiveData<RMCharacter> get() = _characterDetail

    fun getChars(){
        viewModelScope.launch(Dispatchers.IO){
            val response = RMRepo.getChars()
            if (response.isSuccessful) {
//                Log.d("pausechamp", response.body().toString())
                _characters.postValue(response.body())
            }
        }
    }
    fun getCharacter(id: String){
        viewModelScope.launch(Dispatchers.IO){
            val response = RMRepo.getChar(id)
            if (response.isSuccessful){
                _characterDetail.postValue(response.body())
            }
        }
    }
}