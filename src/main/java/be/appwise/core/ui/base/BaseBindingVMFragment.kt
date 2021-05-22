package be.appwise.core.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseBindingVMFragment<B : ViewDataBinding> : BaseVMFragment() {
    protected lateinit var mBinding: B
        private set

    @LayoutRes
    protected abstract fun getLayout(): Int

    /**
     * Don't forget to add your variables to your binding layout
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = DataBindingUtil.inflate(inflater, getLayout(), container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        return mBinding.root
    }
}