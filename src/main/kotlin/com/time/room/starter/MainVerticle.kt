package com.time.room.starter

import com.time.room.config.ControllersConfiguration
import com.time.room.config.controllersModule
import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx
import org.kodein.di.DI
import org.kodein.di.instance

class MainVerticle(private val di: DI) : AbstractVerticle() {

  override fun start() {
    val controllers by di.instance<ControllersConfiguration>()
    val vertx = Vertx.vertx()
    vertx
      .createHttpServer()
      .requestHandler(controllers.createRouter())
      .listen(8888)
  }
}

fun main() {
  val modules = DI {
    importAll(
      controllersModule
    )
  }
  MainVerticle(modules).start()
}
