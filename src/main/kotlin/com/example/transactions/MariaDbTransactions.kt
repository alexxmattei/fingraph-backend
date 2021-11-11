package com.example.transactions

import com.example.models.User
import com.example.models.nomics.CandleData
import com.example.models.nomics.Coin
import com.example.models.nomics.CoinMetadata
import org.jetbrains.exposed.sql.*

class MariaDbTransactions {
    object Users : Table() {
        val id: Column<Int> = integer("userId").autoIncrement().primaryKey();
        val email: Column<String> = varchar("userEmail", 255)
        val password: Column<String> = varchar("password", 255)
        val fullName: Column<String> = varchar("fullName", 255)
        val callingName: Column<String> = varchar("callingName", 255)

        fun toUser(row: ResultRow): User = User(
            id = row[Users.id],
            email = row[Users.email],
            password = row[Users.password],
            fullName = row[Users.fullName],
            callingName = row[Users.callingName]
        )
    }

    object CandleDataSet : Table() {
        val volume: Column<String> = varchar("nCoinCandleVolume", 255).primaryKey();
        val priceChange: Column<Double> = double("nCoinCandlePriceChange");
        val priceChangePct: Column<Double> = double("nCoinCandlePriceChangePct");
        val volumeChange: Column<Double> = double("nCoinCandleVolumeChange");
        val volumeChangePct: Column<Double> = double("nCoinCandleVolumeChangePct");
        val marketCapChange: Column<Double> = double("nCoinCandleMarketCapChange");
        val marketCapChangePct: Column<Double> = double("nCoinCandleMarketCapChangePct")

        fun toNCoinCandleData(row: ResultRow): CandleData = CandleData(
            volume = row[CandleDataSet.volume],
            priceChange = row[CandleDataSet.priceChange],
            priceChangePct = row[CandleDataSet.priceChangePct],
            volumeChange = row[CandleDataSet.volumeChange],
            volumeChangePct = row[CandleDataSet.volumeChangePct],
            marketCapChange = row[CandleDataSet.marketCapChange],
            marketCapChangePct = row[CandleDataSet.marketCapChangePct]
        )
    }

    object Coins : Table() {
        val id: Column<String> = varchar("nCoinId", 255).primaryKey();
        val currency: Column<String> = varchar("nCoinCurrency", 63);
        val symbol: Column<String> = varchar("nCoinSymbol", 31);
        val name: Column<String> = varchar("nCoinName", 63);
        val logo_url: Column<String> = varchar("nCoinLogoUrl", 255);
        val status: Column<String> = varchar("nCoinStatus", 63);
        val price: Column<Double> = double("nCoinPrice");
        val priceDate: Column<String> = varchar("nCoinPriceDate", 255);
        val priceTimestamp: Column<String> = varchar("nCoinPriceTimestamp", 255);
        val circulatingSupply: Column<String> = varchar("nCoinCirculatingSupply", 127);
        val maxSupply: Column<String> = varchar("nCoinMaxSupply", 127);
        val marketCap: Column<String> = varchar("nCoinMarketCap", 255);
        val marketCapDominance: Column<String> = varchar("nMarketCapDominance", 255);
        val numExchanges: Column<String> = varchar("nCoinNumExchanges", 127);
        val numPairs: Column<String> = varchar("nCoinNumPairs", 255);
        val numPairsUnmapped: Column<String> = varchar("nCoinNumPairsUnmapped", 255);
        val firstCandle: Column<String> = varchar("nCoinFirstCandle", 255);
        val firstTrade: Column<String> = varchar("nCoinFirstTrade", 255);
        val firstOrderBook: Column<String> = varchar("nCoinFirstOrderBook", 255);
        val rank: Column<String> = varchar("nCoinRank", 127);
        val high: Column<Double> = double("nCoinHigh");
        val highTimestamp: Column<String> = varchar("nCoinHighTimestamp", 255);

        fun toNCoin(row: ResultRow): Coin = Coin(
            id = row[Coins.id],
            currency = row[Coins.currency],
            symbol = row[Coins.symbol],
            name = row[Coins.name],
            logo_url = row[Coins.logo_url],
            status = row[Coins.status],
            price = row[Coins.price],
            priceDate = row[Coins.priceDate],
            priceTimestamp = row[Coins.priceTimestamp],
            circulatingSupply = row[Coins.circulatingSupply],
            maxSupply = row[Coins.maxSupply],
            marketCap = row[Coins.marketCap],
            marketCapDominance = row[Coins.marketCapDominance],
            numExchanges = row[Coins.numExchanges],
            numPairs = row[Coins.numPairs],
            numPairsUnmapped = row[Coins.numPairsUnmapped],
            firstCandle = row[Coins.firstCandle],
            firstTrade = row[Coins.firstTrade],
            firstOrderBook = row[Coins.firstOrderBook],
            rank = row[Coins.rank],
            high = row[Coins.high],
            highTimestamp = row[Coins.highTimestamp]
        )
    }

    object CoinsMetadata : Table() {
        var id: Column<String> = varchar("nCoinMetadataId", 63).primaryKey();
        var original_symbol: Column<String> = varchar("nCoinMetadataOriginalSymbol", 63);
        var name: Column<String> = varchar("nCoinMetadataName", 63);
        var description: Column<String> = varchar("nCoinMetadataDescription", 16383);
        var website_url: Column<String> = varchar("nCoinMetadataWebsiteUrl", 255);
        var logo_url: Column<String> = varchar("nCoinMetadataWebsiteUrl", 255);
        var blog_url: Column<String> = varchar("nCoinMetadataBlogUrl", 255);
        var discord_url: Column<String> = varchar("nCoinMetadataDiscordUrl", 255);
        var facebook_url: Column<String> = varchar("nCoinMetadataFacebookUrl", 255);
        var github_url: Column<String> = varchar("nCoinMetadataGithubUrl", 255);
        var medium_url: Column<String> = varchar("nCoinMetadataMediumUrl", 255);
        var reddit_url: Column<String> = varchar("nCoinMetadataRedditUrl", 255);
        var telegram_url: Column<String> = varchar("nCoinMetadataTelegramUrl", 255);
        var twitter_url: Column<String> = varchar("nCoinMetadataTwitterUrl", 255);
        var whitepaper_url: Column<String> = varchar("nCoinMetadataWhitepaperUrl", 255);
        var youtube_url: Column<String> = varchar("nCoinMetadataYoutubeUrl", 255);
        var bitcointalk_url: Column<String> = varchar("nCoinMetadataBitcointalkUrl", 255);
        var block_explorer_url: Column<String> = varchar("nCoinMetadataBlockExplorerUrl", 255);
        var replaced_by: Column<String> = varchar("nCoinMetadataReplacedBy", 255);
        var markets_count: Column<Int> = integer("nCoinMetadataMarketsCount");
        var cryptocontrol_coin_id: Column<String> = varchar("nCoinMetadataCryptocontrolCoinId", 255);
        var used_for_pricing: Column<Boolean> = bool("nCoinMetadataUsedForPricing");
        var platform_currency_id: Column<String> = varchar("nCoinMetadataPlatformCurrencyId", 383);
        var platform_contract_address: Column<String> = varchar("nCoinMetadataPlatformContractAddress", 511);

        fun toNCoinMetadata(row: ResultRow): CoinMetadata = CoinMetadata(
            id = row[CoinsMetadata.id],
            original_symbol = row[CoinsMetadata.original_symbol],
            name = row[CoinsMetadata.name],
            description = row[CoinsMetadata.description],
            website_url = row[CoinsMetadata.website_url],
            logo_url = row[CoinsMetadata.logo_url],
            blog_url = row[CoinsMetadata.blog_url],
            discord_url = row[CoinsMetadata.discord_url],
            facebook_url = row[CoinsMetadata.facebook_url],
            github_url = row[CoinsMetadata.github_url],
            medium_url = row[CoinsMetadata.medium_url],
            reddit_url = row[CoinsMetadata.reddit_url],
            telegram_url = row[CoinsMetadata.telegram_url],
            twitter_url = row[CoinsMetadata.twitter_url],
            whitepaper_url = row[CoinsMetadata.whitepaper_url],
            youtube_url = row[CoinsMetadata.youtube_url],
            bitcointalk_url = row[CoinsMetadata.bitcointalk_url],
            block_explorer_url = row[CoinsMetadata.block_explorer_url],
            replaced_by = row[CoinsMetadata.replaced_by],
            markets_count = row[CoinsMetadata.markets_count],
            cryptocontrol_coin_id = row[CoinsMetadata.cryptocontrol_coin_id],
            used_for_pricing = row[CoinsMetadata.used_for_pricing],
            platform_currency_id = row[CoinsMetadata.platform_currency_id],
            platform_contract_address = row[CoinsMetadata.platform_contract_address]
        )
    }
}