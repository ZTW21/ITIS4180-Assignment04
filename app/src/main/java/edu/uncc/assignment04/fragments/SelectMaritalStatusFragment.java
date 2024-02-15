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
import edu.uncc.assignment04.databinding.FragmentSelectMaritalStatusBinding;

public class SelectMaritalStatusFragment extends Fragment {
    public SelectMaritalStatusFragment() {
        // Required empty public constructor
    }

    FragmentSelectMaritalStatusBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSelectMaritalStatusBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelMaritalStatus();
            }
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = binding.radioGroup.getCheckedRadioButtonId();
                String maritalStatus = "";
                if (selectedId == R.id.radioButtonNotMarried) {
                    maritalStatus = "Not Married";
                } else if (selectedId == R.id.radioButtonMarried) {
                    maritalStatus = "Married";
                } else if (selectedId == R.id.radioButtonPreferNotToSay) {
                    maritalStatus = "Prefer not to say";
                }
                mListener.sendMaritalStatus(maritalStatus);
            }
        });
    }

    SelectMaritalStatusFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (SelectMaritalStatusFragmentListener) context;
    }

    public interface SelectMaritalStatusFragmentListener {
        void cancelMaritalStatus();
        void sendMaritalStatus(String maritalStatus);
    }
}