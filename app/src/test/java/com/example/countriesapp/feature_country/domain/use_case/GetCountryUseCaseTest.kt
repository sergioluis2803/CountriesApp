package com.example.countriesapp.feature_country.domain.use_case

import com.example.countriesapp.feature_country.domain.model.DetailCountry
import com.example.countriesapp.feature_country.domain.repository.CountryRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCountryUseCaseTest {
    @RelaxedMockK
    private lateinit var countryRepository: CountryRepository

    lateinit var getCountryUseCase: GetCountryUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getCountryUseCase = GetCountryUseCase(countryRepository)
    }

    @Test
    fun `when the name of country a search is empty`() = runBlocking {
        //Given
        val myList = DetailCountry()
        val name = " "
        coEvery { countryRepository.getCountryDescription(name) } returns myList

        //when
        getCountryUseCase(name)

        //then
        coVerify(exactly = 1) {
            countryRepository.getCountryDescription(name)
        }
    }
}