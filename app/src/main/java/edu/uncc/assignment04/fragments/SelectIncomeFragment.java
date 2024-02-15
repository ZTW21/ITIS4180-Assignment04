package edu.uncc.assignment04.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import edu.uncc.assignment04.R;
import edu.uncc.assignment04.databinding.FragmentSelectIncomeBinding;

public class SelectIncomeFragment extends Fragment {


    public SelectIncomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FragmentSelectIncomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSelectIncomeBinding.inflate(inflater, container, false);

        binding.seekBar.setMax(4);
        binding.seekBar.setProgress(2);


        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int levelStringId;
                switch (progress) {
                    case 0:
                        levelStringId = R.string.level_1;
                        break;
                    case 1:
                        levelStringId = R.string.level_2;
                        break;
                    case 2:
                        levelStringId = R.string.level_3;
                        break;
                    case 3:
                        levelStringId = R.string.level_4;
                        break;
                    case 4:
                        levelStringId = R.string.level_5;
                        break;
                    default:
                        levelStringId = R.string.level_1;
                        break;
                }
                binding.textViewHouseHoldIncome.setText(getString(levelStringId));
            }
            
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Implement if needed
            }
    
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Implement if needed
            }
        });

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelIncome();
            }
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int progress = binding.seekBar.getProgress();
                int levelStringId;
                switch (progress) {
                    case 0:
                        levelStringId = R.string.level_1;
                        break;
                    case 1:
                        levelStringId = R.string.level_2;
                        break;
                    case 2:
                        levelStringId = R.string.level_3;
                        break;
                    case 3:
                        levelStringId = R.string.level_4;
                        break;
                    case 4:
                        levelStringId = R.string.level_5;
                        break;
                    default:
                        levelStringId = R.string.level_1;
                        break;
                }
                mListener.sendIncome(getString(levelStringId));
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    SelectIncomeFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (SelectIncomeFragmentListener) context;
    }

    public interface SelectIncomeFragmentListener {
        void cancelIncome();
        void sendIncome(String income);
    }
}