package com.example.falonzo.santander_challenge

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.falonzo.santander_challenge.common.ServiceUtil
import com.example.falonzo.santander_challenge.common.getOrAwaitValue
import com.example.falonzo.santander_challenge.network.ApiSuccessResponse
import com.example.falonzo.santander_challenge.network.service.CharacterService
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import com.google.common.truth.Truth.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CharacterServiceTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var mockServer: MockWebServer
    private lateinit var service: CharacterService
    @Before
    fun setup() {
        mockServer = MockWebServer()
        service = ServiceUtil.retrofitMock(mockServer).create(CharacterService::class.java)
    }

    @After
    fun then() {
        mockServer.shutdown()
    }

    @Test
    fun test01CheckJsonParse() {
        ServiceUtil.enqueueResponse(mockServer,"characters.json")
        val response = service.getCharacterList().getOrAwaitValue() as ApiSuccessResponse
        assertThat(response).isNotNull()
        response.body.data.let {
            assertThat(it).isNotNull()
            assertThat(it.count).isEqualTo(20)
            it.results.let {
                assertThat(it).isNotEmpty()
                assertThat(it.size).isEqualTo(20)
                it.get(0).let {
                    assertThat(it.id).isEqualTo(1011334)
                    assertThat(it.name).isEqualTo("3-D Man")
                    it.comics.let {
                        assertThat(it.returned).isEqualTo(12)
                        assertThat(it.items.size).isEqualTo(12)
                    }
                    it.series.let {
                        assertThat(it.returned).isEqualTo(3)
                        assertThat(it.items.size).isEqualTo(3)
                    }
                    it.stories.let {
                        assertThat(it.returned).isEqualTo(20)
                        assertThat(it.items.size).isEqualTo(20)
                    }
                }
            }
        }

    }

}