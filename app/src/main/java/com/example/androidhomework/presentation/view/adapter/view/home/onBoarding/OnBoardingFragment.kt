package com.example.androidhomework.presentation.view.adapter.view.home.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentOnBoardingBinding
import com.example.androidhomework.utils.NavHelper.navigate
import com.example.androidhomework.utils.NavHelper.navigateWithDeletedBackStack
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
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