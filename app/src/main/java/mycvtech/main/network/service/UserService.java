package mycvtech.main.network.service;

import mycvtech.main.network.model.UserDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface UserService {


    @GET("users/{userId}")
    Call<UserDto> getUserById(@Path("userId") String userId,@Header("Authorization") String token);
}
