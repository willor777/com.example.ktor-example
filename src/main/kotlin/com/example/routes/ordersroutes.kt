package com.example.routes

import com.example.models.orderStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.listOrderRoute(){
    get("/order"){

        // Verify that orderStorage is not empty then return list
        if (!orderStorage.isEmpty()){
            call.respond(orderStorage)
        }
    }
}


fun Route.getOrderRoute(){
    get("/order/{id?}"){

        // Attempt to pul id from parameters
        val id = call.parameters["id"] ?: return@get call.respondText("Must provide an Id in parameters",
        status = HttpStatusCode.BadRequest)

        // Attempt to find order from orderStorage
        val order = orderStorage.find{it.number == id} ?:return@get call.respondText(
            "Order number not found",
            status = HttpStatusCode.NotFound)

        // Return order
        call.respond(order)
    }
}


fun Route.totalizeOrderRoute(){
    get("/order/{id?}/total"){
        val id = call.parameters["id"] ?: return@get call.respondText("Must include id in paremters",
        status = HttpStatusCode.BadRequest)

        val order = orderStorage.find{it.number == id} ?: return@get call.respondText(
            "No order found matching id",
            status = HttpStatusCode.NotFound
        )

        val total = order.contents.sumOf {
            it.price * it.amount
        }

        call.respond(total)
    }
}