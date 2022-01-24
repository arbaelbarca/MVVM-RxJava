package com.arbaelbarca.grawgames.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.arbaelbarca.grawgames.presentation.model.response.ResponseLatesGames
import com.arbaelbarca.grawgames.presentation.repository.RepositoryHome
import com.arbaelbarca.grawgames.utils.UiState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import retrofit2.Response
import java.util.concurrent.Flow

class ViewModelHome(val repositoryHome: RepositoryHome) : ViewModel() {

    val stateLatesGames = MutableLiveData<UiState<ResponseLatesGames>>()

    fun observerGetLatesGames() = stateLatesGames

    lateinit var disposable: Disposable

    fun callApiLatesGames(map: Map<String, String>) {
        disposable = repositoryHome.getLatesGames(map)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                stateLatesGames.value = UiState.Success(it)
            }) {
                stateLatesGames.value = UiState.Failure(it)
            }
    }


    fun callApiSearchLatesGames(map: Map<String, String>) {
        stateLatesGames.value = UiState.Loading()
        disposable = repositoryHome.getLatesGames(map)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                stateLatesGames.value = UiState.Success(it)
            }) {
                stateLatesGames.value = UiState.Failure(it)
            }

    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}