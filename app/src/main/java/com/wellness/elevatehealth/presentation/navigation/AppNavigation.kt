import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wellness.elevatehealth.presentation.home.HomeScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppDestinations.HOME_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(AppDestinations.HOME_ROUTE) {
            HomeScreen(
                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }

        composable(AppDestinations.NUTRITION_ROUTE) {
            PlaceholderScreen(title = "Food Log")
        }

        composable(AppDestinations.EXERCISE_ROUTE) {
            PlaceholderScreen(title = "Exercise")
        }

        composable(AppDestinations.PROGRESS_ROUTE) {
            PlaceholderScreen(title = "Progress")
        }

        composable(AppDestinations.PROFILE_ROUTE) {
            PlaceholderScreen(title = "Profile")
        }

        // Additional routes for quick actions
        composable("food_log") {
            PlaceholderScreen(title = "Food Log")
        }

        composable("exercise_log") {
            PlaceholderScreen(title = "Exercise Log")
        }

        composable("progress_reports") {
            PlaceholderScreen(title = "Progress Reports")
        }

        composable("recommendations") {
            PlaceholderScreen(title = "Recommendations")
        }
    }
}

@Composable
private fun PlaceholderScreen(title: String) {
    androidx.compose.foundation.layout.Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        androidx.compose.material3.Text(
            text = "$title Screen",
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium
        )
    }
}

object AppDestinations {
    const val HOME_ROUTE = "home"
    const val PROFILE_ROUTE = "profile"
    const val EXERCISE_ROUTE = "exercise"
    const val NUTRITION_ROUTE = "nutrition"
    const val PROGRESS_ROUTE = "progress"
    const val SLEEP_ROUTE = "sleep"
}