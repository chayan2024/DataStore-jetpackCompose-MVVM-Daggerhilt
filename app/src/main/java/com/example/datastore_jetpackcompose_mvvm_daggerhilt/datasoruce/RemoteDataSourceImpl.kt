package com.example.datastore_jetpackcompose_mvvm_daggerhilt.datasoruce

import com.example.datastore_jetpackcompose_mvvm_daggerhilt.model.ItemData

class RemoteDataSourceImpl : RemoteDataSource {
    override suspend fun getItems(): List<ItemData> {
        // Implement logic to fetch items from a remote server
        return listOf(ItemData(1, "Item 1"), ItemData(2, "Item 2"))
    }

    override suspend fun getStringData(): String {
        // Implement logic to fetch string data from a remote server
        return "Sample String Data"
    }

    override suspend fun getMapData(): Map<String, String> {
        // Implement logic to fetch map data from a remote server
        return mapOf("key1" to "value1", "key2" to "value2")
    }
}

