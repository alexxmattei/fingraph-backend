package com.example.models.nomics

import kotlinx.serialization.Serializable

@Serializable
data class CoinMetadata(
    var id: String = "",
    var original_symbol: String = "",
    var name: String = "",
    var description: String = "",
    var website_url: String = "",
    var logo_url: String = "",
    var blog_url: String = "",
    var discord_url: String = "",
    var facebook_url: String = "",
    var github_url: String = "",
    var medium_url: String = "",
    var reddit_url: String = "",
    var telegram_url: String = "",
    var twitter_url: String = "",
    var whitepaper_url: String = "",
    var youtube_url: String = "",
    var bitcointalk_url: String = "",
    var block_explorer_url: String = "",
    var replaced_by: String? = "",
    var markets_count: Int? = 0,
    var cryptocontrol_coin_id: String = "",
    var used_for_pricing: Boolean = false,
    var platform_currency_id: String = "",
    var platform_contract_address: String = ""
)
