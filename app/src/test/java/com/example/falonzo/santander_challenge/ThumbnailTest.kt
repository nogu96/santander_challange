package com.example.falonzo.santander_challenge

import com.example.falonzo.santander_challenge.model.Thumbnail
import org.junit.Test
import com.google.common.truth.Truth.*


class ThumbnailTest {

    @Test
    fun test01URLIsRight() {
        val extension = "jpg"
        val path =  "marvel/image/e"
        val thumbnail = Thumbnail(extension, path)
        assertThat(thumbnail.getUrl()).isEqualTo(path+"."+extension)
    }

}