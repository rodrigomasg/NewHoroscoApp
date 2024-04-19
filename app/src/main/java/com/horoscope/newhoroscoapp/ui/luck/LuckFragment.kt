package com.horoscope.newhoroscoapp.ui.luck

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.horocope.newhoroscoapp.R
import com.horocope.newhoroscoapp.databinding.FragmentLuckBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LuckFragment : Fragment() {
    private var _binding: FragmentLuckBinding? = null
    private val binding get() = _binding!!
    private val luckViewModel by viewModels<LuckViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLuckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initListeners()
    }

    private fun initListeners() {
        binding.luckIV.setOnClickListener { spinImg() }
    }

    private fun spinImg() {
        val random = java.util.Random()
        val degree = random.nextInt(10440) + 360

        val anim = ObjectAnimator.ofFloat(
            binding.luckIV,
            View.ROTATION,
            0f,
            degree.toFloat()
        )
        anim.duration = 20000
        anim.interpolator = DecelerateInterpolator()
        anim.doOnEnd { slideCard() }
        anim.start()
    }

    private fun slideCard() {
        val slideUp = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)
        slideUp.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                binding.luckIvreverse.isVisible = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                growCard()
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })
        binding.luckIvreverse.startAnimation(slideUp)
    }

    private fun growCard() {
        val growAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.grow)
        growAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.luckIvreverse.isVisible = false
                showPremonitionView()
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })
        binding.luckIvreverse.startAnimation(growAnim)
    }

    private fun showPremonitionView() {
        val dissapear = AlphaAnimation(1.0f, 0.0f)
        dissapear.duration = 200

        val appearAnim = AlphaAnimation(0.0f, 1.0f)
        appearAnim.duration = 1000

        dissapear.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.luckPreview.isVisible = false
                binding.luckPrediction.isVisible = true
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })
        binding.luckPreview.startAnimation(dissapear)
        binding.luckPrediction.startAnimation(appearAnim)
    }


}