package com.example.falonzo.santander_challenge.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.falonzo.santander_challenge.common.CallUtil
import com.example.falonzo.santander_challenge.common.InstantAppExecutors
import com.example.falonzo.santander_challenge.common.TestUtil
import com.example.falonzo.santander_challenge.model.Character
import com.example.falonzo.santander_challenge.model.Resource
import com.example.falonzo.santander_challenge.model.Status
import com.example.falonzo.santander_challenge.network.service.CharacterService
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import com.google.common.truth.Truth.*
import io.mockk.*
import org.junit.Rule

@RunWith(JUnit4::class)
class CharacterRepositoryTest {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var characterRepository: CharacterRepository
    private val characterService = mockk<CharacterService>()

    @Before
    fun setup() {
        characterRepository = CharacterRepository(InstantAppExecutors(), characterService)
    }

    @After
    fun clean() {
        unmockkAll()
    }

    @Test
    fun `Test 01 get characterList`() {
        val call = CallUtil.success(TestUtil.generateBaseResponse(TestUtil.generateListResponse(listOf(TestUtil.generateCharacter(0)))))
        every { characterService.getCharacterList() } returns call
        val response = characterRepository.getCharacterList()

        assertThat(response.value?.status).isEqualTo(Status.LOADING)

        val observer = spyk<Observer<Resource<List<Character>>>>()
        response.observeForever(observer)
        verify(exactly = 1) { characterService.getCharacterList() }
        assertThat(response.value?.status).isEqualTo(Status.SUCCESS)
        response.value?.data?.let {
            assertThat(it).isNotEmpty()
            assertThat(it.get(0).id).isEqualTo(0)
        }
        response.removeObserver(observer)
    }

}