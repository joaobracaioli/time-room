package com.time.room.controllers

import io.vertx.core.AbstractVerticle
import io.vertx.core.Handler
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext

class TrainingController : AbstractVerticle() {

  public fun createRouter() = Router.router(vertx).apply {
    get("/").handler(handlerRoot)
    get("/islands").handler(handlerIslands)
    get("/countries").handler(handlerCountries)
  }

  //
  // Handlers

  val handlerRoot = Handler<RoutingContext> { req ->
    req.response().end("Welcome!")
  }

  val handlerIslands = Handler<RoutingContext> { req ->

    req.response().end(JsonObject().put("hello", "world").toString())
  }

  val handlerCountries = Handler<RoutingContext> { req ->
    req.response().end(JsonObject().put("hello", "world").toString())
  }
}
