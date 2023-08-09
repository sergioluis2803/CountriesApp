package com.example.countriesapp.feature_country.domain.use_case

import com.example.countriesapp.domain.use_case.GetCountriesUseCase
import com.example.countriesapp.data.model.CountryModel
import com.example.countriesapp.data.model.Demonyms
import com.example.countriesapp.data.model.Eng
import com.example.countriesapp.data.model.Flags
import com.example.countriesapp.data.model.Name
import com.example.countriesapp.data.CountryRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCountriesUseCaseTest {

    @RelaxedMockK
    private lateinit var countryRepository: CountryRepository

    lateinit var getCountriesUseCase: GetCountriesUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getCountriesUseCase = GetCountriesUseCase(countryRepository)
    }

    @Test
    fun `when the api return values`() = runBlocking {
        //Given
        val myList = listOf(
            CountryModel(
                false, "American", "American", Name("Peru", "Peru"), listOf("Lima"), Demonyms(
                    Eng("peruvian", "peruvian")
                ), listOf("America"), Flags("")
            )
        )
        coEvery { countryRepository.getAllCountries() } returns myList

        //When
        getCountriesUseCase()

        //Then
        coVerify(exactly = 1) { countryRepository.getAllCountries() }
    }
}