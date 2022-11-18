package com.example.qualyuppretask


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.qualyuppretask.databinding.FragmentLastStepBinding

class LastStepFragment : Fragment() {
    private lateinit var binding: FragmentLastStepBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_last_step, container, false)
        val countries = listOf(Country(R.drawable.egypt,"+20"),Country(R.drawable.saudi,"+966"),Country(R.drawable.tunisia,"+216"))

        binding.customPhoneEdittext.spinner.adapter = CountryAdapter(countries)
        binding.customPhoneEdittext.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val country = parent?.getItemAtPosition(position) as Country
                binding.customPhoneEdittext.keyCode.text = country.key
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        
        binding.customPhoneEdittext.editPhone.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus){
                binding.customPhoneEdittext.hint.visibility = View.VISIBLE
                binding.customPhoneEdittext.helperText.setTextColor(ContextCompat.getColor(requireContext(), R.color.purple_500))
            }else{
                binding.customPhoneEdittext.hint.visibility = View.GONE
                binding.customPhoneEdittext.helperText.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.tab_indicator_text))
            }
        }
        return binding.root
    }
}