package mycvtech.main.network.service;

import mycvtech.main.network.model.AuthenticationRequest;
import retrofit2.Call;
import mycvtech.main.network.model.AuthenticationResponse;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface AuthService {

    @POST("auth/authenticate")
    Call<AuthenticationResponse> logIn(@Body AuthenticationRequest user);



}
