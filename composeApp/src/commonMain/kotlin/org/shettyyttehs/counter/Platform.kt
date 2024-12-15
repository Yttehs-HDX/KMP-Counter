package org.shettyyttehs.counter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform