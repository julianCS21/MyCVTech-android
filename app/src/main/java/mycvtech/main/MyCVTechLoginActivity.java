package mycvtech.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import mycvtech.main.R;
import mycvtech.main.databinding.LoginPageBinding;


public class MyCVTechLoginActivity extends AppCompatActivity {

    private LoginPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = LoginPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_login_view, FragmentLogin.class, null)
                .commit();
    }




}
