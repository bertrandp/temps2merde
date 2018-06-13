package com.bertrandp.injection.component

import com.bertrandp.injection.PerActivity
import com.bertrandp.injection.module.ActivityModule
import com.bertrandp.features.base.BaseActivity
import com.bertrandp.features.detail.DetailActivity
import com.bertrandp.features.main.MainActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(baseActivity: BaseActivity)

    fun inject(mainActivity: MainActivity)

    fun inject(detailActivity: DetailActivity)
}
