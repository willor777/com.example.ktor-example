package com.example.plugins

import com.example.routes.customerRoute
import com.example.routes.getOrderRoute
import com.example.routes.listOrderRoute
import com.example.routes.totalizeOrderRoute
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*


// This fun is invoked in the Application Module Function
// It is responsible for 'registering' our routes
fun Application.configureRouting() {
    routing {

        // Register a route by calling it here
        // These are all the Route.extensionFunctions() we created
        customerRoute()
        listOrderRoute()
        getOrderRoute()
        totalizeOrderRoute()
    }
}
