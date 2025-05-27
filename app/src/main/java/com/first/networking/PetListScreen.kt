package com.first.networking

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun PetListScreen(viewModel: PetViewModel) {
    val pets = viewModel.pets.value
    val isLoading = viewModel.isLoading.value
    val error = viewModel.error.value

    if (isLoading) {
        CircularProgressIndicator()
    } else if (error != null) {
        Text(text = error)
    } else {
        LazyColumn {
            items(pets) { pet ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        AsyncImage(model = pet.image, contentDescription = pet.name)
                        Text("Name: ${pet.name}")
                        Text("Age: ${pet.age}")
                        Text("Gender: ${pet.gender}")
                        Text("Adopted: ${if (pet.adopted) "Yes" else "No"}")
                    }
                }
            }
        }
    }
}
