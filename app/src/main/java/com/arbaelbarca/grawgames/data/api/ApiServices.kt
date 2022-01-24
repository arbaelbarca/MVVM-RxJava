package com.arbaelbarca.grawgames.data.api

import com.arbaelbarca.grawgames.presentation.model.response.ResponseLatesGames
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiServices {

    @GET("games")
    fun callApiGetLateGames(
        @QueryMap map: Map<String, String>
    ): Observable<ResponseLatesGames>

}