package com.talk.sphere.login.presentation

data class UserUIState(
    val success: Boolean,
    val name: String?,
    val email: String?,
    val phone: String,
    val bloodGroup: String?,
    val emergencyContactPhone: String?,
    val emergencyContactRelation: String?,
    val profileImage: String?,
    val isVerified: Boolean,
    val isAdmin: Boolean,
    val showProgress: Boolean,
    val isLoading: Boolean,
    val isError: Boolean,
    val isOtpScreen: Boolean,
    val aboutMe: String,
    val bikeBrand: String,
    val bikeModel: String,
    val createdAt: String,
    val status: String,
    val joinedRides: Int,
    val createdRides: Int,
    val distanceRun: Int,
    val showEditDialog: Boolean,
    val updateProfileLoading: Boolean

    ) {
    companion object {
        val defaultState: UserUIState
            get() = UserUIState(
                success = false,
                name = "",
                email = "",
                phone = "",
                bloodGroup = "",
                emergencyContactPhone = "",
                emergencyContactRelation = "",
                profileImage = "",
                isVerified = false,
                isAdmin = false,
                showProgress = false,
                isLoading = false,
                isError = false,
                isOtpScreen = false,
                aboutMe = "",
                bikeBrand = "",
                bikeModel = "",
                createdAt = "",
                status = "Active",
                joinedRides = 0,
                createdRides = 0,
                distanceRun = 0,
                showEditDialog = false,
                updateProfileLoading = false
            )
    }
}