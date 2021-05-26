package com.time.room.config

import com.time.room.controllers.TrainingController
import org.koin.core.qualifier.named
import org.koin.dsl.module

val controllersModule = module {
  single(named("controllers")) { TrainingController() }
}
