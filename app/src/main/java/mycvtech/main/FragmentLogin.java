package mycvtech.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import java.util.List;

import mycvtech.main.databinding.FragmentLoginFormBinding;
import mycvtech.main.network.RetrofitClient;
import mycvtech.main.network.model.AuthenticationRequest;
import mycvtech.main.network.model.AuthenticationResponse;
import mycvtech.main.network.service.AuthService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentLogin extends Fragment {

    FragmentLoginFormBinding binding;

    public static  String token = "";

    public static String id = "";

    public FragmentLogin() {
        super(R.layout.fragment_login_form);
    }

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentLoginFormBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.email.getText().toString();
                String password = binding.password.getText().toString();
                logIn(email, password);
            }
        });
    }

    private void logIn(String email, String password) {
        AuthService authService = RetrofitClient.getRetrofitInstance(token).create(AuthService.class);
        AuthenticationRequest user = new AuthenticationRequest(email, password);
        Call<AuthenticationResponse> call = authService.logIn(user);

        call.enqueue(new Callback<AuthenticationResponse>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<AuthenticationResponse> call, @NonNull Response<AuthenticationResponse> response) {
                if (response.isSuccessful()) {
                    AuthenticationResponse jwtToken = response.body();
                    token = jwtToken.getToken();
                    id = jwtToken.getId();
                    Log.d("token", token);
                    Intent intent = new Intent(getActivity(), MyCVTechProfileActivity.class);
                    startActivity(intent);

                } else {

                    binding.errorMessage.setVisibility(View.VISIBLE);
                    binding.errorMessage.setText("Email o contraseña incorrectos");
                }
            }

            @Override
            public void onFailure(@NonNull Call<AuthenticationResponse> call, @NonNull Throwable t) {
                Log.e("ERROR", "Error: " + t.getMessage(), t);
            }
        });
    }

}
