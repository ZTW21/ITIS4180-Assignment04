package edu.uncc.assignment04.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.uncc.assignment04.Response;
import edu.uncc.assignment04.databinding.FragmentIdentificationBinding;

public class IdentificationFragment extends Fragment {



    public IdentificationFragment() {
        // Required empty public constructor
    }

    FragmentIdentificationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentIdentificationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFields(binding.editTextName, binding.editTextEmail, binding.radioGroup);
            }
        });
    }

    IdentificationFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (IdentificationFragmentListener) context;
    }

    public interface IdentificationFragmentListener {
        void goToDemographic(Response response);
    }


    private void validateFields(TextView nameTextView, TextView emailTextView, RadioGroup roleRadioGroup) {
        StringBuilder missingFields = new StringBuilder();
        Context context = getContext();
        int duration = Toast.LENGTH_LONG;

        if (nameTextView.getText().toString().trim().isEmpty()) {
            missingFields.append("Name, ");
        }

        String email = emailTextView.getText().toString().trim();
        if (email.isEmpty() || !isValidEmail(email)) {
            missingFields.append("Email, ");
        }

        int selectedId = roleRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = roleRadioGroup.findViewById(selectedId);
        if (selectedId == -1) { // No selection made in the RadioGroup
            missingFields.append("Role, ");
        }

        if (missingFields.length() > 0) {
            // Remove the last comma and space
            missingFields.setLength(missingFields.length() - 2);
            Toast.makeText(context, "Please complete the following fields: " + missingFields, duration).show();
        } else {
            mListener.goToDemographic(new Response(nameTextView.getText().toString(), email, selectedRadioButton.getText().toString()));
        }
    }

    public static boolean isValidEmail(CharSequence email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}