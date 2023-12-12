package mycvtech.main;

import static mycvtech.main.FragmentLogin.id;
import static mycvtech.main.FragmentLogin.token;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import mycvtech.main.databinding.FragmentLoginFormBinding;
import mycvtech.main.databinding.FragmentProfileFormBinding;
import mycvtech.main.network.RetrofitClient;
import mycvtech.main.network.model.UserDto;
import mycvtech.main.network.service.UserService;
import mycvtech.main.network.ui.ExpertiseAdapter;
import mycvtech.main.network.ui.SoftSkillAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        binding.recyclerViewSkills.setAdapter(new SoftSkillAdapter(new ArrayList<>()));
        binding.recyclerViewExpertise.setAdapter(new ExpertiseAdapter(new ArrayList<>()));
        getUserById(id);


        binding.btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "";
                token = "";
                Intent intent = new Intent(getActivity(), MyCVTechLoginActivity.class);
                startActivity(intent);
            }
        });


    }

    private void getUserById(String id) {


        UserService userService = RetrofitClient.getRetrofitInstance().create(UserService.class);


        Call<UserDto> call = userService.getUserById(id, "Bearer " + token);
        call.enqueue(new Callback<UserDto>() {
            @Override
            public void onResponse(Call<UserDto> call, Response<UserDto> response) {
                if (response.isSuccessful() && response.body() != null) {
                    UserDto userDto = response.body();
                    binding.FirstName.setText(userDto.getFirstName());
                    binding.LastName.setText(userDto.getLastName());
                    binding.email.setText(userDto.getEmail());
                    binding.phone.setText(userDto.getPhone());
                    binding.academicProgram.setText(userDto.getAcademicProgram());
                    binding.semester.setText(userDto.getSemester());
                    binding.interestedArea.setText(userDto.getInterestedArea());
                    Log.d("softskills","" + userDto.getSoftSkills().size());
                    Log.d("expertise","" + userDto.getExpertise().size());
                    if(userDto.getSoftSkills() != null){
                        SoftSkillAdapter softSkillAdapter = new SoftSkillAdapter(userDto.getSoftSkills());
                        binding.recyclerViewSkills.setAdapter(softSkillAdapter);
                    }
                    if(userDto.getExpertise() != null){
                        ExpertiseAdapter expertiseAdapter = new ExpertiseAdapter(userDto.getExpertise());
                        binding.recyclerViewExpertise.setAdapter(expertiseAdapter);
                    }



                } else {
                    Log.e("getUserById", "Error al obtener los detalles del usuario");
                }
            }

            @Override
            public void onFailure(Call<UserDto> call, Throwable t) {

                Log.e("getUserById", "Error en la llamada a la API: " + t.getMessage());
            }
        });
    }
}
