package com.example.datastore_jetpackcompose_mvvm_daggerhilt.datasoruce

import com.example.datastore_jetpackcompose_mvvm_daggerhilt.model.ItemData

class LocalDataSourceImpl : LocalDataSource {
    private var itemsCache: List<ItemData> = emptyList()
    private var stringDataCache: String = ""
    private var mapDataCache: Map<String, String> = emptyMap()

    override suspend fun saveItems(items: List<ItemData>) {
        itemsCache = items
    }

    override suspend fun getItems(): List<ItemData> {
        return itemsCache
    }

    override suspend fun saveStringData(data: String) {
        stringDataCache = data
    }

    override suspend fun getStringData(): String {
        return stringDataCache
    }

    override suspend fun saveMapData(data: Map<String, String>) {
        mapDataCache = data
    }

    override suspend fun getMapData(): Map<String, String> {
        return mapDataCache
    }
}
