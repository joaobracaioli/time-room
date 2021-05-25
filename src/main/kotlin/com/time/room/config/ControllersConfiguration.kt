package com.time.room.config

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.Handler
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val controllersModule = DI.Module("controllers") {
  bind<ControllersConfiguration>() with singleton { ControllersConfiguration() }
}
class ControllersConfiguration : AbstractVerticle() {

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
