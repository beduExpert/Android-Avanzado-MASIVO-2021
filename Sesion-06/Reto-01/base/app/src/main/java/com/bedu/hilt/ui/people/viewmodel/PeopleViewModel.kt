package com.bedu.hilt.ui.people.viewmodel

import androidx.lifecycle.*
import com.bedu.hilt.data.model.People
import com.bedu.hilt.data.repository.MainRepository
import com.bedu.hilt.utils.NetworkHelper
import com.bedu.hilt.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _people = MutableLiveData<Resource<List<People>>>()
    val people: LiveData<Resource<List<People>>>
        get() = _people

    init {
        fetchUsers()
    }

    fun onRefresh() {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _people.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getPeople().let {
                    if (it.isSuccessful) {
                        _people.postValue(Resource.success(it.body()?.results))
                    } else _people.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _people.postValue(Resource.error("No internet connection", null))
        }
    }
}