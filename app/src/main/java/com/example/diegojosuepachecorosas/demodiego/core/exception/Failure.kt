package com.example.diegojosuepachecorosas.demodiego.core.exception

sealed class Failure : Throwable() {
    class NetworkConnection : Failure()
    class ServerError : Failure()
    class ConflictFailure(val code:String,override val message:String): Failure()

    abstract class FeatureFailure : Failure()
}