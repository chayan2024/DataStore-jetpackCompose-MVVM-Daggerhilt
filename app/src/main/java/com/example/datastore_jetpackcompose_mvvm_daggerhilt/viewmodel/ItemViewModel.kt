package com.example.datastore_jetpackcompose_mvvm_daggerhilt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.datastore_jetpackcompose_mvvm_daggerhilt.model.ItemData
import com.example.datastore_jetpackcompose_mvvm_daggerhilt.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    private val _items = MutableStateFlow<List<ItemData>>(emptyList())
    val items: StateFlow<List<ItemData>> get() = _items

    init {
        val mockItems = listOf(
            ItemData(1,"Item 1"),
            ItemData(2,"Item 2"),
            ItemData(3,"Item 3")
        )

        viewModelScope.launch {
            // Collect the items flow and process items
           _items.value=mockItems
        }
    }

    fun getItems() = liveData {
        emit(repository.getItems())
    }

    fun getStringData() = liveData {
        emit(repository.getStringData())
    }

    fun getMapData() = liveData {
        emit(repository.getMapData())
    }
}
