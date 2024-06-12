package com.example.claimassured.my_garage.model

import com.example.claimassured.utils.PriorityColor

data class MyGarageModel(
    val policyNumberTxt: String,
    val vehicleNumberTxt: String,
    val vehicleNameTxt: String,
    val vehicleModelTxt: String,
    val ownerNameTxt: String,
    val locationTxt: String,
    val assignedToTxt: String,
    val tatBreachedTxt: String,
    val claimIntimatedOnTxt: String,
    val ageingTxt: String,
    val priorityColor: PriorityColor,
    val isWorkerRowVisible: Boolean,
    val isLocationRowVisible: Boolean,
    val canSlideToAssign: Boolean
)

