package com.wellness.elevatehealth.data.repository.model

import kotlinx.serialization.Serializable

@Serializable
data class HomepageResponse(
    val userInfo: UserInfo,
    val todayActivity: TodayActivity,
    val nutrition: Nutrition,
    val weeklyProgress: WeeklyProgress,
    val quickActions: List<QuickAction>
)

@Serializable
data class UserInfo(
    val id: String,
    val name: String,
    val greeting: String
)

@Serializable
data class TodayActivity(
    val caloriesBurned: Int,
    val duration: String,
    val exercises: List<String>
)

@Serializable
data class Nutrition(
    val caloriesConsumed: Int,
    val calorieGoal: Int,
    val meals: List<String>
)

@Serializable
data class WeeklyProgress(
    val weightChange: Double,
    val unit: String,
    val onTrack: Boolean,
    val message: String
)

@Serializable
data class QuickAction(
    val title: String,
    val icon: String,
    val color: String
)