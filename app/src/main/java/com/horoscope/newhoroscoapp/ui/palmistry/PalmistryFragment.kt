package com.horoscope.newhoroscoapp.ui.palmistry

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment
import com.horocope.newhoroscoapp.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "palmistryFragment"

@AndroidEntryPoint
class PalmistryFragment : Fragment() {
    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!
    private val requestPermision = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            openCamera()
        } else {
            Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        const val CAMERA_PERMISSION = Manifest.permission.CAMERA
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmistryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        validatePermission()
    }

    private fun validatePermission() {
        if (checkPermissionCamera()) {
            openCamera()
        } else {
            requestPermision.launch(CAMERA_PERMISSION)
        }
    }

    private fun openCamera() {
        val cameraProvide = ProcessCameraProvider.getInstance(requireContext())
        cameraProvide.addListener({
            val cameraPro = cameraProvide.get()
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.pPreview.surfaceProvider)
                }

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                cameraPro.unbindAll()

                cameraPro.bindToLifecycle(this, cameraSelector, preview)
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }, ContextCompat.getMainExecutor(requireContext()))
    }

    private fun checkPermissionCamera(): Boolean {
        return PermissionChecker.checkSelfPermission(
            requireContext(),
            CAMERA_PERMISSION
        ) == PermissionChecker.PERMISSION_GRANTED
    }

}