package com.apps.coinwhatchcryptocurrency.ui.screen.market

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MarketScreen(){
    Box(modifier = Modifier.fillMaxWidth(),
        contentAlignment= Alignment.Center,
        ){
        Text(
            text = "Market Screen ",
            modifier = Modifier
        )
    }

}