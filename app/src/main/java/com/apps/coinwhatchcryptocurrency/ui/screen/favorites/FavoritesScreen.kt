package com.apps.coinwhatchcryptocurrency.ui.screen.favorites

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun FavouritesScreen(){
    Box(modifier = Modifier.fillMaxWidth(),
        contentAlignment= Alignment.Center,
        ){
        Text(
            text = "Favorites Screen ",
            modifier = Modifier
        )
    }

}