package com.bedu.hilt.ui.planets.viewmodel

import androidx.lifecycle.*
import com.bedu.hilt.data.model.Planet
import com.bedu.hilt.data.repository.MainRepository
import com.bedu.hilt.utils.NetworkHelper
import com.bedu.hilt.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetsViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _planet = MutableLiveData<Resource<List<Planet>>>()
    val planet: LiveData<Resource<List<Planet>>>
        get() = _planet

    init {
        fetch()
    }

    fun onRefresh() {
        fetch()
    }

    private fun fetch() {
        viewModelScope.launch {
            _planet.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getPlanets().let {
                    if (it.isSuccessful) {
                        _planet.postValue(Resource.success(it.body()?.results))
                    } else _planet.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _planet.postValue(Resource.error("No internet connection", null))
        }
    }
}