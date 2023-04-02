package com.example.test.application.usecase.command

import com.example.test.domain.Payment
import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import kotlin.coroutines.CoroutineContext

@Service
class RefundCommandHandler: CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.IO + SupervisorJob()

    fun refund(payment: Payment) {
        launch {
            when (payment.refund()) {
                true -> {
                    println("COROUTINE REFUND END ThreadId = " + Thread.currentThread().id + " 현재 시간 = " + LocalDateTime.now())
                    println("payment = $payment")
                }
                false -> {
                    println(LocalDateTime.now())
                    throw RuntimeException("Failed to refund")
                }
            }
        }

        println("REFUND END ThreadId = " + Thread.currentThread().id + " 현재 시간 = " + LocalDateTime.now())
    }
}