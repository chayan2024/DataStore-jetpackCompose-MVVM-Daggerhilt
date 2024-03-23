package com.example.datastore_jetpackcompose_mvvm_daggerhilt.datasoruce

import com.example.datastore_jetpackcompose_mvvm_daggerhilt.model.ItemData

interface LocalDataSource {
    suspend fun saveItems(items: List<ItemData>)
    suspend fun getItems(): List<ItemData>
    suspend fun saveStringData(data: String)
    suspend fun getStringData(): String
    suspend fun saveMapData(data: Map<String, String>)
    suspend fun getMapData(): Map<String, String>
}