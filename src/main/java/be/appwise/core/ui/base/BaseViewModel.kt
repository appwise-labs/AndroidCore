package be.appwise.core.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.appwise.core.ui.SomeManager
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

abstract class BaseViewModel() : ViewModel() {
    @Suppress("MemberVisibilityCanBePrivate")
    var vmScope: CoroutineScope

    private val _loading = MutableLiveData<Boolean>().apply { value = false }
    val loading get() = _loading as LiveData<Boolean>
    private fun isLoading(loading: Boolean) {
        _loading.postValue(loading)
    }

    init {
        vmScope = vmScopeWithCustomExceptionHandler()
    }

    private suspend fun showLoading(onSuccess: suspend () -> Unit) {
        isLoading(true)
        onSuccess()
        isLoading(false)
    }

    fun launchAndLoad(onSuccess: suspend () -> Unit) = vmScope.launch {
        showLoading(onSuccess)
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun vmScopeWithCustomExceptionHandler() =
        (viewModelScope + CoroutineExceptionHandler { _, throwable ->
            isLoading(false)
            SomeManager.listener?.onViewModelError(throwable)
        })
}