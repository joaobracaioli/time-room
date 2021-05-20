package com.time.room.starter

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.Promise
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.Router

class MainVerticle : AbstractVerticle() {

  override fun start(startPromise: Promise<Void>) {
    val route = Router.router(vertx)
    route.route("/some/path") // this handler will ensure that the response is serialized to json
      // the content type is set to "application/json"
      .respond { ctx -> Future.succeededFuture(JsonObject().put("hello", "world")) }

    vertx
      .createHttpServer()
      .requestHandler(route)
      .listen(8888) { http ->
        if (http.succeeded()) {
          startPromise.complete()
          println("HTTP server started on port 8888")
        } else {
          startPromise.fail(http.cause())
        }
      }
  }
}
