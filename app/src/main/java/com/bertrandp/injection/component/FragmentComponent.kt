package com.bertrandp.injection.component

import com.bertrandp.injection.PerFragment
import com.bertrandp.injection.module.FragmentModule
import dagger.Subcomponent

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = arrayOf(FragmentModule::class))
interface FragmentComponent