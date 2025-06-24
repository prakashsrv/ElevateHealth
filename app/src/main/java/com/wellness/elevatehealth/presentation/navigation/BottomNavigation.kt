package com.wellness.elevatehealth.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

data class BottomNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String
)

val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        route = AppDestinations.HOME_ROUTE
    ),
    BottomNavItem(
        title = "Food",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Done,
        route = AppDestinations.NUTRITION_ROUTE
    ),
    BottomNavItem(
        title = "Exercise",
        selectedIcon = Icons.Filled.Face,
        unselectedIcon = Icons.Outlined.ArrowForward,
        route = AppDestinations.EXERCISE_ROUTE
    ),
    BottomNavItem(
        title = "Progress",
        selectedIcon = Icons.Filled.Build,
        unselectedIcon = Icons.Outlined.ArrowForward,
        route = AppDestinations.EXERCISE_ROUTE
    ),
    BottomNavItem(
        title = "Profile",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        route = AppDestinations.PROFILE_ROUTE
    )
)

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        bottomNavItems.forEach { item ->
            val isSelected = currentRoute == item.route

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(text = item.title)
                },
                selected = isSelected,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}