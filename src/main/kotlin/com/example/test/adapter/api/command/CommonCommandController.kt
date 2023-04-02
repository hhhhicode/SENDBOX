package com.example.test.adapter.api.command

import com.example.test.application.usecase.command.RefundCommandHandler
import com.example.test.domain.Payment
import kotlinx.coroutines.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/common")
class CommonCommandController(
    private val refundCommandHandler: RefundCommandHandler
) {

    @PostMapping("/deferred/test")
    fun deferredTest(
        @RequestBody payment: Payment
    ) = payment.let {

        refundCommandHandler.refund(it)

        ResponseEntity
            .ok()
            .body("Immediate response")
    }
}