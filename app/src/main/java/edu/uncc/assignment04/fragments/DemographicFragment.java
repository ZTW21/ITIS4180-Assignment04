package edu.uncc.assignment04.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import edu.uncc.assignment04.R;
import edu.uncc.assignment04.Response;
import edu.uncc.assignment04.databinding.FragmentDemographicBinding;

public class DemographicFragment extends Fragment {
    private static final String ARG_PARAM_RESPONSE = "ARG_PARAM_RESPONSE";
    private Response mResponse;

    public DemographicFragment() {
        // Required empty public constructor
    }

    public static DemographicFragment newInstance(Response response) {
        DemographicFragment fragment = new DemographicFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_RESPONSE, response);
        fragment.setArguments(args);
        return fragment;
    }

    FragmentDemographicBinding binding;

    boolean isEducationSelected = false;
    boolean isMaritalSelected = false;
    boolean isLivingSelected = false;
    boolean isIncomeSelected = false;

    private String selectedEducation = null;
    private String selectedMaritalStatus = null;
    private String selectedLivingStatus = null;
    private String selectedIncome = null;

    public void setSelectedEducation (String education) {
        this.selectedEducation = education;
    }

    public void setSelectedMaritalStatus (String maritalStatus) {
        this.selectedMaritalStatus = maritalStatus;
    }

    public void setSelectedLivingStatus (String livingStatus) {
        this.selectedLivingStatus = livingStatus;
    }

    public void setSelectedIncome (String income) {
        this.selectedIncome = income;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mResponse = (Response) getArguments().getSerializable(ARG_PARAM_RESPONSE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDemographicBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSelectEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToEducation();
            }
        });

        binding.buttonSelectMarital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToMaritalStatus();
            }
        });

        binding.buttonSelectLiving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToLivingStatus();
            }
        });

        binding.buttonSelectIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToIncome();
            }
        });

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEducationSelected && isMaritalSelected && isLivingSelected && isIncomeSelected) {
                    Response response = new Response(mResponse.getName(), mResponse.getEmail(), mResponse.getRole(), selectedEducation, selectedMaritalStatus, selectedLivingStatus, selectedIncome);
                    mListener.goToProfile(response);
                } else {
                    Toast.makeText(getContext(), "Please select all options", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if (selectedEducation == null) {
            binding.textViewEducation.setText("N/A");
        } else {
            binding.textViewEducation.setText(selectedEducation);
            isEducationSelected = true;
        }

        if (selectedMaritalStatus == null) {
            binding.textViewMaritalStatus.setText("N/A");
        } else {
            binding.textViewMaritalStatus.setText(selectedMaritalStatus);
            isMaritalSelected = true;
        }

        if (selectedLivingStatus == null) {
            binding.textViewLivingStatus.setText("N/A");
        } else {
            binding.textViewLivingStatus.setText(selectedLivingStatus);
            isLivingSelected = true;
        }

        if (selectedIncome == null) {
            binding.textViewIncomeStatus.setText("N/A");
        } else {
            binding.textViewIncomeStatus.setText(selectedIncome);
            isIncomeSelected = true;
        }
    }

    DemographicFragment.DemographicFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (DemographicFragment.DemographicFragmentListener) context;
    }

    public interface DemographicFragmentListener {
        void goToEducation();
        void goToMaritalStatus();
        void goToLivingStatus();
        void goToIncome();
        void goToProfile(Response response);
    }
}