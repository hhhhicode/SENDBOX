package com.example.test.domain

import kotlinx.coroutines.delay

data class Payment(
    var amount: Int,
    var quantity: Int,
) {
    suspend fun refund(): Boolean {

        delay(3600000L)
        this.amount = 0
        this.quantity = 0

        return true
    }
}
