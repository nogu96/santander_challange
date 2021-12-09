package com.example.falonzo.santander_challenge.common

import com.example.falonzo.santander_challenge.model.*

object TestUtil {

    fun generateCharacter(
        id: Int,
        comics: Container<AssetResource> = generateContainer(),
        description: String = "",
        events: Container<AssetResource> = generateContainer(),
        modified: String = "",
        name: String = "",
        resourceURI: String = "",
        series: Container<AssetResource> = generateContainer(),
        stories: Container<AssetResource> = generateContainer(),
        thumbnail: Thumbnail = generateThumbnail(),
        urls: List<Url> = listOf()
    ): Character {
        return Character(
            id,
            comics,
            description,
            events,
            modified,
            name,
            resourceURI,
            series,
            stories,
            thumbnail,
            urls
        )
    }

    fun <T>generateContainer(
        available: Int = 1,
        collectionURI: String = "",
        items: List<T> = listOf(),
        returned: Int = items.size ,
    ): Container<T> {
        return Container(available, collectionURI, items, returned)
    }

    fun generateThumbnail(
        extension: String = "",
        url: String = ""
    ): Thumbnail {
        return Thumbnail(extension, url)
    }

    fun generateUrl(
        type: String = "",
        url: String = ""
    ): Url {
        return Url(type, url)
    }

    fun <T>generateBaseResponse(
        data: ListResponse<T>,
        attributionHTML: String = "",
        attributionText: String = "",
        code: Int = 0,
        copyright: String = "",
        etag: String = "",
        status: String = ""
    ): BaseResponse<T> {
        return BaseResponse(
            attributionHTML,
            attributionText,
            code,
            copyright,
            data,
            etag,
            status
        )
    }

    fun <T>generateListResponse(
        results: List<T>,
        count: Int = results.size,
        limit: Int = 0,
        offset: Int = 0,
        total: Int = results.size
    ): ListResponse<T> {
        return ListResponse(
            count,
            limit,
            offset,
            results,
            total
        )
    }
}