package be.appwise.core.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseBindingVMActivity<B : ViewDataBinding> : BaseVMActivity() {
    protected lateinit var mBinding: B
        private set

    @LayoutRes
    protected abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, getLayout())
        mBinding.lifecycleOwner = this
    }
}
