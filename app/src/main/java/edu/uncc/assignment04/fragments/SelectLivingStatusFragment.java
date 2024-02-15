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
import edu.uncc.assignment04.databinding.FragmentSelectLivingStatusBinding;

public class SelectLivingStatusFragment extends Fragment {
    public SelectLivingStatusFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FragmentSelectLivingStatusBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSelectLivingStatusBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelLivingStatus();
            }
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = binding.radioGroup.getCheckedRadioButtonId();
                String livingStatus = "";
                if (selectedId == R.id.radioButtonHomeOwner) {
                    livingStatus = "Home Owner";
                } else if (selectedId == R.id.radioButtonRenter) {
                    livingStatus = "Renter";
                } else if (selectedId == R.id.radioButtonLessee) {
                    livingStatus = "Lessee";
                } else if  (selectedId == R.id.radioButtonOther) {
                    livingStatus = "Other";
                } else if (selectedId == R.id.radioButtonPreferNotToSay) {
                    livingStatus = "Prefer not to say";
                }
                mListener.sendLivingStatus(livingStatus);
            }
        });
    }

    SelectLivingStatusFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (SelectLivingStatusFragmentListener) context;
    }

    public interface SelectLivingStatusFragmentListener {
        void cancelLivingStatus();
        void sendLivingStatus(String livingStatus);
    }
}