package com.nassdk.musand

import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

val navigationModule = module {

    val cicerone: Cicerone<Router> = Cicerone.create(Router())
    single { cicerone.router }
    single { cicerone.navigatorHolder }
}