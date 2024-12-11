package com.javieriq.artinstitvte.data.repositories

import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {
    override fun getGreeting(): String = "Hello from Repository!"
}