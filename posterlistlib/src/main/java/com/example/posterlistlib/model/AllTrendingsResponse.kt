package com.example.posterlistlib.model

data class AllTrendingsResponse(
    val page: Int,
    val results: List<AllTrending>,
    val total_pages: Int,
    val total_results: Int
)