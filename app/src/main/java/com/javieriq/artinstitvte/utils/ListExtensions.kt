package com.javieriq.artinstitvte.utils

fun <T> List<T>?.orEmptyList(): List<T> = this ?: emptyList()