package ch.ost.rj.mge.android_minesweeper.fragments

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ch.ost.rj.mge.android_minesweeper.R
import ch.ost.rj.mge.android_minesweeper.databinding.FragmentHelpBinding
import java.io.IOException

class HelpFragment : Fragment() {
    private var _binding : FragmentHelpBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_POSITION = "position"

        fun getInstance(position: Int): Fragment {
            val helpFragment = HelpFragment()
            val bundle = Bundle()
            bundle.putInt(ARG_POSITION, position)
            helpFragment.arguments = bundle
            return helpFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentHelpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val position = requireArguments().getInt(ARG_POSITION)
        val imageFilePath = getString(R.string.help_image_path, position)

        val helpTitles = requireContext().resources.getStringArray(R.array.help_titles)
        val helpDescriptions = requireContext().resources.getStringArray(R.array.help_descriptions)

        setImageFromAssetsFile(requireContext(), imageFilePath)
        binding.helpTitle.text = helpTitles[position]
        binding.helpDescription.text = helpDescriptions[position]
    }

    private fun setImageFromAssetsFile(context: Context, filePath: String) {
        val imageBitmap: Bitmap?
        val assets = context.resources.assets
        try {
            val fileStream = assets.open(filePath)
            imageBitmap = BitmapFactory.decodeStream(fileStream)
            fileStream.close()
            binding.helpImage.setImageBitmap(imageBitmap)
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(context, getString(R.string.image_loading_error), Toast.LENGTH_SHORT).show()
        }
    }
}