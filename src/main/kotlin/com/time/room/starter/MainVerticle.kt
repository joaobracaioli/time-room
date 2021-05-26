package com.time.room.starter

import com.time.room.config.controllersModule
import com.time.room.controllers.TrainingController
import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.inject

class MainVerticle() : AbstractVerticle() {

  override fun start() {
    val controllers : TrainingController by inject(clazz = TrainingController::class.java,  qualifier = named("controllers"))

    val vertx = Vertx.vertx()
    vertx
      .createHttpServer()
      .requestHandler(controllers.createRouter())
      .listen(8888)
  }
}

fun main() {
  startKoin {
    // use Koin logger
    printLogger()
    // declare modules
    modules(controllersModule)
  }

  MainVerticle().start()
}
