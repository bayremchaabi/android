package Utils;

import java.util.List;

import Model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UtilisateurService {
    @GET("/userss")
    Call<List<User>> getAllUsers();

    @POST("/userss/addd")
    Call<Void> addUser(@Body User user);


}
