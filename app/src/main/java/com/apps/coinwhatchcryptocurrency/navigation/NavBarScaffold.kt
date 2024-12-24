package com.apps.coinwhatchcryptocurrency.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.apps.coinwhatchcryptocurrency.ui.screen.favorites.FavouritesScreen
import com.apps.coinwhatchcryptocurrency.ui.screen.market.MarketScreen
import com.apps.coinwhatchcryptocurrency.ui.screen.search.SearchScreen
import kotlinx.collections.immutable.persistentListOf

@Composable
fun NavBarScaffold(
    startScreen: NavigationBarScreen,
    onNavigationDetails: (String) -> Unit,
    onNavigationSettings: () -> Unit,
    modifier: Modifier
) {
    val navController = rememberNavController()
    val navigationBarScreen = remember {
        persistentListOf(
            NavigationBarScreen.Market,
            NavigationBarScreen.Favourites,
            NavigationBarScreen.Search
        )
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val showNavigationBar = navigationBarScreen.any { it.route == currentDestination?.route }
    Scaffold(
        bottomBar = {
            if (showNavigationBar) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    tonalElevation = 0.dp
                ) {
                    navigationBarScreen.forEach { screen ->
                        AddNavigationBarItem(
                            screen = screen,
                            currentDestination = currentDestination,
                            navController = navController,
                        )
                    }
                }
            }
        },
        content = { scaffoldPadding ->
            NavigationBarNavHost(
                navController = navController,
                startScreen = startScreen,
                onNavigateDetails = onNavigationDetails,
                onNavigateSettings = onNavigationSettings,
                modifier = Modifier.padding(scaffoldPadding)
            )
        }
    )


}

@Composable
fun RowScope.AddNavigationBarItem(
    screen: NavigationBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val selected = currentDestination?.hierarchy?.any { destination ->
        destination.route == screen.route
    } == true
    NavigationBarItem(
        label = {
            Text(
                text = stringResource(screen.nameResourcesId),
                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
            )
        },
        icon = {
            Icon(
                imageVector = when (screen) {
                    NavigationBarScreen.Market -> Icons.Rounded.Home
                    NavigationBarScreen.Favourites -> Icons.Rounded.Favorite
                    NavigationBarScreen.Search -> Icons.Rounded.Search
                },
                contentDescription = null

            )
        },
        selected = selected,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = MaterialTheme.colorScheme.onSurface,
            selectedTextColor = MaterialTheme.colorScheme.onSurface,
            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
            indicatorColor = MaterialTheme.colorScheme.background
        ),
        modifier = Modifier
    )


}

@Composable
fun NavigationBarNavHost(
    navController: NavHostController,
    startScreen: NavigationBarScreen,
    onNavigateDetails: (String) -> Unit,
    onNavigateSettings: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startScreen.route,
        modifier = modifier
    ) {
        composable(route = NavigationBarScreen.Market.route) {
            MarketScreen()
        }
        composable(route = NavigationBarScreen.Favourites.route) {
            FavouritesScreen()
        }
        composable(route = NavigationBarScreen.Search.route) {
            SearchScreen()
        }

    }
}
