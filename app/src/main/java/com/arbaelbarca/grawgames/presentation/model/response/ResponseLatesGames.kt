package com.arbaelbarca.grawgames.presentation.model.response

data class ResponseLatesGames(
    val count: Int?,
    val next: String?,
    val previous: Any?,
    val results: List<ResultGames?>?,
    val user_platforms: Boolean?
) {
    data class ResultGames(
        val added: Int?,
        val added_by_status: AddedByStatus?,
        val background_image: String?,
        val clip: Any?,
        val community_rating: Int?,
        val dominant_color: String?,
        val esrb_rating: Any?,
        val genres: List<Genre?>?,
        val id: Int?,
        val metacritic: Any?,
        val name: String?,
        val parent_platforms: List<ParentPlatform?>?,
        val platforms: List<Platform?>?,
        val playtime: Int?,
        val rating: Double?,
        val rating_top: Int?,
        val ratings: List<Any?>?,
        val ratings_count: Int?,
        val released: String?,
        val reviews_count: Int?,
        val reviews_text_count: Int?,
        val saturated_color: String?,
        val score: Any?,
        val short_screenshots: List<ShortScreenshot?>?,
        val slug: String?,
        val stores: List<Store?>?,
        val suggestions_count: Int?,
        val tags: List<Tag?>?,
        val tba: Boolean?,
        val updated: String?,
        val user_game: Any?
    ) {
        data class AddedByStatus(
            val owned: Int?,
            val toplay: Int?
        )

        data class Genre(
            val id: Int?,
            val name: String?,
            val slug: String?
        )

        data class ParentPlatform(
            val platform: Platform?
        ) {
            data class Platform(
                val id: Int?,
                val name: String?,
                val slug: String?
            )
        }

        data class Platform(
            val platform: Platform?
        ) {
            data class Platform(
                val id: Int?,
                val name: String?,
                val slug: String?
            )
        }

        data class ShortScreenshot(
            val id: Int?,
            val image: String?
        )

        data class Store(
            val store: Store?
        ) {
            data class Store(
                val id: Int?,
                val name: String?,
                val slug: String?
            )
        }

        data class Tag(
            val games_count: Int?,
            val id: Int?,
            val image_background: String?,
            val language: String?,
            val name: String?,
            val slug: String?
        )
    }
}