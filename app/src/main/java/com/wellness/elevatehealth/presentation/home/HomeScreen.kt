package com.wellness.elevatehealth.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wellness.elevatehealth.data.all.model.HomepageResponse
import com.wellness.elevatehealth.data.all.model.QuickAction
import com.wellness.elevatehealth.presentation.common.components.ErrorMessage
import com.wellness.elevatehealth.presentation.common.components.LoadingIndicator
import com.wellness.elevatehealth.presentation.home.components.*

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(modifier = modifier.fillMaxSize()) {
        when {
            uiState.isLoading -> {
                LoadingIndicator(fullScreen = true)
            }
            uiState.isError -> {
                ErrorMessage(
                    message = uiState.error ?: "An error occurred",
                    onRetry = { viewModel.retryLoading() }
                )
            }
            uiState.isSuccess -> {
                uiState.homepageData?.let { data ->
                    HomepageContent(
                        homepageData = data,
                        onQuickActionClick = { action ->
                            handleQuickActionClick(action, onNavigate)
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
private fun HomepageContent(
    homepageData: HomepageResponse,
    onQuickActionClick: (QuickAction) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Greeting Header
        item {
            GreetingHeader(userInfo = homepageData.userInfo)
        }

        // Activity and Nutrition Cards Row
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ActivityCard(
                    todayActivity = homepageData.todayActivity,
                    modifier = Modifier.weight(1f)
                )
                NutritionCard(
                    nutrition = homepageData.nutrition,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Weekly Progress Card
        item {
            WeeklyProgressCard(weeklyProgress = homepageData.weeklyProgress)
        }

        // Quick Actions
        item {
            QuickActionsGrid(
                quickActions = homepageData.quickActions,
                onActionClick = onQuickActionClick
            )
        }

        // Add bottom padding for navigation bar
        item {
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

private fun handleQuickActionClick(action: QuickAction, onNavigate: (String) -> Unit) {
    when (action.title) {
        "Food Log" -> onNavigate("food_log")
        "Exercise Log" -> onNavigate("exercise_log")
        "Progress Reports" -> onNavigate("progress_reports")
        "Recommendations" -> onNavigate("recommendations")
        "Profile" -> onNavigate("profile")
        else -> {
            // Handle unknown action or show a message
        }
    }
}