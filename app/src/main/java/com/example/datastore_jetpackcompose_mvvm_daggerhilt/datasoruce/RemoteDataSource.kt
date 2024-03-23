package com.example.datastore_jetpackcompose_mvvm_daggerhilt.datasoruce

import com.example.datastore_jetpackcompose_mvvm_daggerhilt.model.ItemData

interface RemoteDataSource {
    suspend fun getItems(): List<ItemData>
    suspend fun getStringData(): String
    suspend fun getMapData(): Map<String, String>}