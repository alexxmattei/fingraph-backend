package com.example.models.coingecko

interface Page {
    val total: Int
    val perPage: Int
    val nextPage: Int?
    val previousPage: Int?
}
