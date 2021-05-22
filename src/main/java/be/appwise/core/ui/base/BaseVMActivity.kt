package be.appwise.core.ui.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import be.appwise.core.ui.SomeManager

abstract class BaseVMActivity : BaseActivity(), SomeManager.Listener {

    override fun onViewModelError(th: Throwable) {
        onError(th)
    }

    /**
     * Reference to the viewModel that will be used for this Activity.
     * When using this class, you should override [mViewModel] by using `by viewModels()`
     *
     * ```kotlin
     *     override val mViewModel: MainViewModel by viewModels()
     * ```
     *
     * you can even add a [ViewModelFactory] to it if needed.
     *
     *```kotlin
     *     override val mViewModel: MainViewModel by viewModels() { getViewModelFactory() }
     * ```
     */
    protected abstract val mViewModel: BaseViewModel

    protected open fun getViewModelFactory(): ViewModelProvider.NewInstanceFactory =
        ViewModelProvider.NewInstanceFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SomeManager.listener = this
    }
}
