package com.apps.coinwhatchcryptocurrency.navigation

import androidx.annotation.StringRes
import com.apps.coinwhatchcryptocurrency.R

sealed class NavigationBarScreen(
    val route: String,
    @StringRes val nameResourcesId: Int
) {
    data object Market : NavigationBarScreen(
        route = "market_screen",
        nameResourcesId = R.string.market_screen
    )

    data object Favourites : NavigationBarScreen(
        route = "favorite_screen",
        nameResourcesId = R.string.favourites_screen
    )

    data object Search : NavigationBarScreen(
        route = "search_screen",
        nameResourcesId = R.string.search_screen
    )

}

sealed class Screen(val route: String) {
    data object Details : Screen("details_screen")
    data object Settings : Screen("settings_screen")
    data object NavigationBar : Screen("navigation_bar_screen")
}
