package com.example.datastore_jetpackcompose_mvvm_daggerhilt.repository

import com.example.datastore_jetpackcompose_mvvm_daggerhilt.datasoruce.LocalDataSource
import com.example.datastore_jetpackcompose_mvvm_daggerhilt.datasoruce.RemoteDataSource
import com.example.datastore_jetpackcompose_mvvm_daggerhilt.model.ItemData
import javax.inject.Inject

class ItemRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {
    suspend fun getItems(): List<ItemData> {
        return localDataSource.getItems().takeIf { it.isNotEmpty() }
            ?: remoteDataSource.getItems().also { localDataSource.saveItems(it) }
    }

    suspend fun getStringData(): String {
        return localDataSource.getStringData().takeIf { it.isNotEmpty() }
            ?: remoteDataSource.getStringData().also { localDataSource.saveStringData(it) }
    }

    suspend fun getMapData(): Map<String, String> {
        return localDataSource.getMapData().takeIf { it.isNotEmpty() }
            ?: remoteDataSource.getMapData().also { localDataSource.saveMapData(it) }
    }
}

