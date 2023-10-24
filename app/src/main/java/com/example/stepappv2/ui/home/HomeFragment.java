package com.example.stepappv2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.stepappv2.R;
import com.example.stepappv2.databinding.FragmentHomeBinding;
import com.google.android.material.progressindicator.CircularProgressIndicator;

import java.util.Locale;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TextView stepCountsView;
    private CircularProgressIndicator progressBar;
    private int steps_count = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        stepCountsView = (TextView) root.findViewById(R.id.counter);
        stepCountsView.setText(String.format(Locale.ROOT, "%d", steps_count));

        progressBar = (CircularProgressIndicator) root.findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setProgress(0);

        Button start_button = (Button) root.findViewById(R.id.start_button);
        start_button.setOnClickListener(v -> {
            steps_count = 0;
            progressBar.setProgress(steps_count);
            stepCountsView.setText(String.format(Locale.ROOT, "%d", steps_count));
        });

        Button button_count = (Button) root.findViewById(R.id.button_count);
        button_count.setOnClickListener(v -> {
            steps_count += 1;
            progressBar.setProgress(steps_count);
            stepCountsView.setText(String.format(Locale.ROOT, "%d", steps_count));
        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}