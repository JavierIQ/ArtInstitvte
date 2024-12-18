package com.javieriq.artinstitvte.utils

object CacheManager {
    private const val CACHE_EXPIRY_TIME = 1000 * 60 * 60 // 1 hour in milliseconds

    fun isCacheExpired(lastUpdatedTime: Long): Boolean {
        return System.currentTimeMillis() - lastUpdatedTime > CACHE_EXPIRY_TIME
    }
}