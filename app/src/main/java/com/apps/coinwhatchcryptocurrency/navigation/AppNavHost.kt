package com.apps.coinwhatchcryptocurrency.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.apps.coinwhatchcryptocurrency.ui.screen.detail.DetailScreen
import com.apps.coinwhatchcryptocurrency.ui.screen.settings.SettingsScreen

@Composable
fun AppNavHost(
    navigationBarStartScreen: NavigationBarScreen = NavigationBarScreen.Market,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.NavigationBar.route,
    ) {
        composable(Screen.NavigationBar.route) {
            NavBarScaffold(
                startScreen = navigationBarStartScreen,
                onNavigationDetails = {coinId->
                    navController.navigate(Screen.Details.route+ "/$coinId")
                },
                onNavigationSettings = {
                    navController.navigate(Screen.Settings.route)
                },
                modifier = Modifier
            )
        }
        composable(
            Screen.Details.route + "/{coinId}",
        ) {
            DetailScreen()
        }
        composable(Screen.Settings.route){
            SettingsScreen()
        }


    }
}