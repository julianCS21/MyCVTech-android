package mycvtech.main;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import mycvtech.main.databinding.ProfilePageBinding;
import mycvtech.main.R;
import mycvtech.main.network.RetrofitClient;
import mycvtech.main.network.model.AuthenticationRequest;
import mycvtech.main.network.model.AuthenticationResponse;
import mycvtech.main.network.service.AuthService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyCVTechProfileActivity extends AppCompatActivity {

    private ProfilePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ProfilePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_profile_view, FragmentProfile.class, null)
                .commit();






    }





}





