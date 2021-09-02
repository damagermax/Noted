package com.example.noted.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.noted.R
import com.example.noted.ui.note.AddNoteActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewBottomSheet : BottomSheetDialogFragment(), View.OnClickListener {

    private lateinit var audioSection: RelativeLayout
    private lateinit var textSection: RelativeLayout
    private lateinit var listSection: RelativeLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.new_bottom_sheet_fragment, container, false)
        audioSection = view.findViewById(R.id.audionSection)
        textSection = view.findViewById(R.id.textSection)
        listSection = view.findViewById(R.id.listSection)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        audioSection.setOnClickListener(this)
        textSection.setOnClickListener(this)
        listSection.setOnClickListener(this)
    }


    override fun onClick(viewClicked: View?) {
        when (viewClicked?.id) {

            R.id.audionSection -> {
                Toast.makeText(requireContext(), "audio", Toast.LENGTH_LONG).show()
            }
            R.id.textSection -> {
                val intent = Intent(requireContext(), AddNoteActivity::class.java)
                startActivity(intent)
            }
            R.id.listSection -> {
                Toast.makeText(requireContext(), "list", Toast.LENGTH_LONG).show()
            }

        }
    }
}