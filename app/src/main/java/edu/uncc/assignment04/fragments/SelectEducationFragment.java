package edu.uncc.assignment04.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uncc.assignment04.R;
import edu.uncc.assignment04.databinding.FragmentSelectEducationBinding;

public class SelectEducationFragment extends Fragment {

    public SelectEducationFragment() {
        // Required empty public constructor
    }

    FragmentSelectEducationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSelectEducationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelEducation();
            }
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = binding.radioGroup.getCheckedRadioButtonId();
                String education = "";
                if (selectedId == R.id.radioButtonBHS) {
                    education = "Below High School";
                } else if (selectedId == R.id.radioButtonHS) {
                    education = "High School";
                } else if (selectedId == R.id.radioButtonBS) {
                    education = "Bachelor's Degree";
                } else if (selectedId == R.id.radioButtonMS) {
                    education = "Master's Degree";
                } else if (selectedId == R.id.radioButtonPHD) {
                    education = "Ph.D or Higher";
                } else if (selectedId == R.id.radioButtonTS) {
                    education = "Trade School";
                } else if (selectedId == R.id.radioButtonPreferNotToSay) {
                    education = "Prefer Not To Say";
                }

                mListener.sendEducation(education);
            }
        });
    }

    SelectEducationFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (SelectEducationFragmentListener) context;
    }

    public interface SelectEducationFragmentListener {
        void sendEducation(String education);
        void cancelEducation();
    }

}