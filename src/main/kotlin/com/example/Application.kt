package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit {

    // Check if port is provided (is deployed)
    val port = System.getenv("PORT")

    // Testing on local machine
    if (port == null){
        io.ktor.server.netty.EngineMain.main(args)
    }

    // Deployed
    else{
        embeddedServer(Netty, port = port.toInt()){
        }.start(wait = true)
    }
}

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSerialization()
    configureRouting()
}
