package com.example.criminalintent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment


class CrimeFragment : Fragment() {

    private lateinit var titleField: EditText
    private lateinit var dateButton: Button


    private lateinit var crime: Crime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        crime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)

        titleField = view.findViewById(R.id.crime_title) as EditText
        dateButton = view.findViewById(R.id.crime_date) as Button

        dateButton.apply {
            text = crime.date.toString()
            isEnabled = false
        }


        return view
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher {
            override fun afterTextChanged(sequace: Editable?) {

            }

            override fun beforeTextChanged(sequace: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(sequace: CharSequence?, p1: Int, p2: Int, p3: Int) {
                crime.title = sequace.toString()
            }
        }

        titleField.addTextChangedListener(titleWatcher)
    }
}