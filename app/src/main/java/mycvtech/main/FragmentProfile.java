package mycvtech.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import mycvtech.main.databinding.FragmentLoginFormBinding;
import mycvtech.main.databinding.FragmentProfileFormBinding;

public class FragmentProfile extends Fragment {
    FragmentProfileFormBinding binding;

    public FragmentProfile() {
        super(R.layout.fragment_profile_form);
    }

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentProfileFormBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
