package com.example.claimassured.my_garage.ui.test

import com.example.claimassured.my_garage.model.MyGarageModel
import com.example.claimassured.utils.PriorityColor

class TestClass {

    companion object{

        private fun getRandomColor(): PriorityColor {
            return PriorityColor.entries.toTypedArray().random()
        }

        private fun getRandomBoolean(): Boolean {
            return listOf(true, false).random()
        }

        private fun getRandomString(length: Int): String {
            val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
            return (1..length)
                .map { allowedChars.random() }
                .joinToString("")
        }

        fun generateUnassignedTaskList(count: Int): List<MyGarageModel> {
            val result = mutableListOf<MyGarageModel>()
            for (i in 1..count) {
                result.add(
                    MyGarageModel(
                        policyNumberTxt = "Policy-${getRandomString(6)}",
                        vehicleNumberTxt = "Vehicle-${getRandomString(8)}",
                        vehicleNameTxt = "Car $i",
                        vehicleModelTxt = "Model ${getRandomString(4)}",
                        ownerNameTxt = "Owner ${getRandomString(7)}",
                        locationTxt = "Location ${getRandomString(5)}",
                        assignedToTxt = "Worker ${getRandomString(6)}",
                        tatBreachedTxt = if (getRandomBoolean()) "Yes" else "No",
                        claimIntimatedOnTxt = "Date-${getRandomString(8)}",
                        ageingTxt = "${(1..100).random()} days",
                        priorityColor = getRandomColor(),
                        isWorkerRowVisible = false,
                        isLocationRowVisible = false,
                        canSlideToAssign = true,
                        isBtnSliderVisible = true
                    )
                )
            }
            return result
        }

        fun generateAssignedTaskList(count: Int): List<MyGarageModel> {
            val result = mutableListOf<MyGarageModel>()
            for (i in 1..count) {
                result.add(
                    MyGarageModel(
                        policyNumberTxt = "Policy-${getRandomString(6)}",
                        vehicleNumberTxt = "Vehicle-${getRandomString(8)}",
                        vehicleNameTxt = "Car $i",
                        vehicleModelTxt = "Model ${getRandomString(4)}",
                        ownerNameTxt = "Owner ${getRandomString(7)}",
                        locationTxt = "Location ${getRandomString(5)}",
                        assignedToTxt = "Worker ${getRandomString(6)}",
                        tatBreachedTxt = if (getRandomBoolean()) "Yes" else "No",
                        claimIntimatedOnTxt = "Date-${getRandomString(8)}",
                        ageingTxt = "${(1..100).random()} days",
                        priorityColor = getRandomColor(),
                        isWorkerRowVisible = true,
                        isLocationRowVisible = false,
                        canSlideToAssign = true,
                        isBtnSliderVisible = true
                    )
                )
            }
            return result
        }

        fun generateCompletedTaskList(count: Int): List<MyGarageModel> {
            val result = mutableListOf<MyGarageModel>()
            for (i in 1..count) {
                result.add(
                    MyGarageModel(
                        policyNumberTxt = "Policy-${getRandomString(6)}",
                        vehicleNumberTxt = "Vehicle-${getRandomString(8)}",
                        vehicleNameTxt = "Car $i",
                        vehicleModelTxt = "Model ${getRandomString(4)}",
                        ownerNameTxt = "Owner ${getRandomString(7)}",
                        locationTxt = "Location ${getRandomString(5)}",
                        assignedToTxt = "Worker ${getRandomString(6)}",
                        tatBreachedTxt = if (getRandomBoolean()) "Yes" else "No",
                        claimIntimatedOnTxt = "Date-${getRandomString(8)}",
                        ageingTxt = "${(1..100).random()} days",
                        priorityColor = getRandomColor(),
                        isWorkerRowVisible = true,
                        isLocationRowVisible = false,
                        canSlideToAssign = false,
                        isBtnSliderVisible = false
                    )
                )
            }
            return result
        }
    }
}