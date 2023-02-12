package com.example.androidhomework.presentation.view.adapter.view.home.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentOnBoardingBinding
import com.example.androidhomework.utils.App
import com.example.androidhomework.utils.NavHelper.navigate
import javax.inject.Inject


class OnBoardingFragment : Fragment(), OnBoardingView {

    @Inject
    lateinit var onBoardingPresenter: OnBoardingPresenter

    private var _viewBinding: FragmentOnBoardingBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentOnBoardingBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)
        onBoardingPresenter.setView(this)

        onBoardingPresenter.checkUserViewOnBoarding()

        viewBinding.btnGoToItemsFragment.setOnClickListener {
            onBoardingPresenter.viewOnBoarding(KEY)
        }

    }

    override fun userViewOnBoardingResult(userViewOnBoarding: Boolean) {
        if (userViewOnBoarding) {
            navigate(R.id.action_onBoardingFragment_to_itemsFragment)
        }
    }

    override fun userViewOnBoarding() {
        navigate(R.id.action_onBoardingFragment_to_itemsFragment)
    }



    companion object {
        private const val KEY = "KEY"
    }

}