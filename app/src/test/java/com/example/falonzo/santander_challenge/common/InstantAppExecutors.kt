package com.example.falonzo.santander_challenge.common

import com.example.falonzo.santander_challenge.AppExecutors
import java.util.concurrent.Executor

class InstantAppExecutors : AppExecutors(instant, instant, instant) {
    companion object {
        private val instant = Executor { it.run() }
    }
}