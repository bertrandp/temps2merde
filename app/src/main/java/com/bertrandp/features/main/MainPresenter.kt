package com.bertrandp.features.main

import com.bertrandp.data.DataManager
import com.bertrandp.data.model.RainForecast
import com.bertrandp.injection.ConfigPersistent
import com.bertrandp.features.base.BasePresenter
import com.bertrandp.util.rx.scheduler.SchedulerUtils
import javax.inject.Inject

@ConfigPersistent
class MainPresenter @Inject
constructor(private val mDataManager: DataManager) : BasePresenter<MainMvpView>() {

    override fun attachView(mvpView: MainMvpView) {
        super.attachView(mvpView)
    }

    fun getData(limit: Int) {
        checkViewAttached()
        mvpView?.showProgress(true)
        mDataManager.getPokemonList(limit)
                .compose(SchedulerUtils.ioToMain<List<String>>())
                .subscribe({ pokemons ->
                    mvpView?.showProgress(false)
                    mvpView?.showPokemon(pokemons)
                }) { throwable ->
                    mvpView?.showProgress(false)
                    mvpView?.showError(throwable)
                }

        mDataManager.getLyonWhether()
                .compose<RainForecast>(SchedulerUtils.ioToMain<RainForecast>())
                .subscribe({ rainForecast ->
                    // It should be always checked if MvpView (Fragment or Activity) is attached.
                    // Calling showProgress() on a not-attached fragment will throw a NPE
                    // It is possible to ask isAdded() in the fragment, but it's better to ask in the presenter
                    mvpView?.showProgress(false)
                    mvpView?.showForecast(rainForecast)

                }) { throwable ->
                    mvpView?.showProgress(false)
                    mvpView?.showError(throwable)
                }
    }

}