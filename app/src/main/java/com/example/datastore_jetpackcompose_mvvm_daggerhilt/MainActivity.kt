package com.example.datastore_jetpackcompose_mvvm_daggerhilt
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModelProvider
import com.example.datastore_jetpackcompose_mvvm_daggerhilt.model.ItemData
import com.example.datastore_jetpackcompose_mvvm_daggerhilt.viewmodel.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Observe the StateFlow from the ViewModel
            val items by remember { viewModel.items }.collectAsState(emptyList())

            // Display the list of items
            ItemList(items)
        }
    }
    @Composable
    fun ItemList(items: List<ItemData>) {
        LazyColumn {
            items(items) { item ->
                Text(text = item.name)
            }
        }
    }
}
