package com.ouday.test.core.network

data class Result<out T>(val status: Status, val data: T?, val message: String?) {

    var exception: Exception? = null

    constructor(status: Status, data: T?, message: String? = null, exception: Exception?) : this(
        status,
        data,
        message ?: ""
    ) {
        this.exception = exception
    }

    companion object {
        fun <T> success(data: T?): Result<T> {
            return Result(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T? = null): Result<T> {
            return Result(Status.ERROR, data, msg)
        }

        fun <T> error(exception: Exception, data: T? = null): Result<T> {
            return Result(Status.ERROR, data, exception = exception)
        }

        fun <T> loading(): Result<T> {
            return Result(Status.LOADING, null, null)
        }
    }
}

enum class Status {
    LOADING,
    ERROR,
    SUCCESS
}
