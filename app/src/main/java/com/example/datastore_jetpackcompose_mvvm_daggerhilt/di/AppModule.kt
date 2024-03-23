package com.example.datastore_jetpackcompose_mvvm_daggerhilt.di

import com.example.datastore_jetpackcompose_mvvm_daggerhilt.datasoruce.LocalDataSource
import com.example.datastore_jetpackcompose_mvvm_daggerhilt.datasoruce.LocalDataSourceImpl
import com.example.datastore_jetpackcompose_mvvm_daggerhilt.datasoruce.RemoteDataSource
import com.example.datastore_jetpackcompose_mvvm_daggerhilt.datasoruce.RemoteDataSourceImpl
import com.example.datastore_jetpackcompose_mvvm_daggerhilt.repository.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRemoteDataSource(): RemoteDataSource {
        return RemoteDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(): LocalDataSource {
        return LocalDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideItemRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): ItemRepository {
        return ItemRepository(remoteDataSource, localDataSource)
    }
}
