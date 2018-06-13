package com.bertrandp.common.injection.component

import dagger.Component
import com.bertrandp.common.injection.module.ApplicationTestModule
import com.bertrandp.injection.component.AppComponent
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationTestModule::class))
interface TestComponent : AppComponent