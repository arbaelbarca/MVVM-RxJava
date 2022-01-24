package com.arbaelbarca.grawgames.presentation.repository

import com.arbaelbarca.grawgames.data.api.ApiServices
import com.arbaelbarca.grawgames.presentation.model.response.ResponseLatesGames
import io.reactivex.Observable

class RepositoryHome(val apiServices: ApiServices) {

    fun getLatesGames(map: Map<String, String>): Observable<ResponseLatesGames> {
        return apiServices.callApiGetLateGames(map)
    }
}