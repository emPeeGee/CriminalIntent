package com.example.criminalintent

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

private const val ARG_PATH = "patharg"

class ZoomedPhotoFragment : DialogFragment() {

    private lateinit var photoImageView: ImageView


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_zoomed_photo, null)
        val photoPath = arguments?.getString(ARG_PATH, "") as String

        photoImageView = view.findViewById(R.id.photo_holder) as ImageView
        val bitmap = getScaledBitmap(photoPath, requireActivity())

        photoImageView.setImageBitmap(bitmap)

        return AlertDialog.Builder(requireActivity())
            .setView(view)
            .create()
    }

    companion object {
        fun newInstance(path: String): ZoomedPhotoFragment {

            val args = Bundle().apply {
                putSerializable(ARG_PATH, path)
            }

            return ZoomedPhotoFragment().apply {
                arguments = args
            }
        }
    }
}