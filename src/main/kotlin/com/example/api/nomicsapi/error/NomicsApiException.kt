package com.example.api.nomicsapi.error

import com.example.api.nomicsapi.error.NomicsApiError

class NomicsApiException : Exception {
    var error: NomicsApiError? = null
        private set

    constructor(error: NomicsApiError?) {
        this.error = error
    }

    constructor(cause: Throwable?) : super(cause)
    constructor(message: String?, cause: Throwable?) : super(message, cause)

    override val message: String
        get() = error?.toString() ?: super.message ?: "<no message>"
}