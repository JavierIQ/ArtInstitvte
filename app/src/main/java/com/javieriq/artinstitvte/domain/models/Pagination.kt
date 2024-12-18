package com.javieriq.artinstitvte.domain.models

data class Pagination(
    val total: Int,
    val limit: Int,
    val offset: Int,
    val totalPages: Int,
    val currentPage: Int,
    val nextUrl: String? = null,
    val prevUrl: String? = null
)
