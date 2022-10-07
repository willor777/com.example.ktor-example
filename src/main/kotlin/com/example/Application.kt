package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>){

    // Check if port is provided as an env var
    val port = System.getenv("PORT")

    // Testing on local machine by calling the Netty Engine's main function.
    // This method of starting the server allows for no configuration beyond the .conf file
    if (port == null){
        io.ktor.server.netty.EngineMain.main(args)

    }

    // Deployed to cloud environment where PORT is provided as an Environment Variable.
    // embeddedServer() is called and given a Server 'Netty' to use. You can provide additional
    // configuration here by using named args or by calling the named arg 'configure' and passing it a lambda.
    // More information https://ktor.io/docs/engines.html#choose-create-server
    else{

        embeddedServer(Netty, port = port.toInt()){
        }.start(wait = true)
    }
}

// application.conf adds this extension function as a module to our application.
// You can have multiple modules by defining more ext functions like Application.moduleOne().
// This annotation prevents the IDE from marking it as unused.
@Suppress("unused")
fun Application.module() {
    configureSerialization()
    configureRouting()
}
