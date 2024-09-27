package com.onthecrow.kmparchsample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform