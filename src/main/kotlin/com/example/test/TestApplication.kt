package com.example.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class TestApplication

fun main(args: Array<String>) {
	runApplication<TestApplication>(*args)
}
