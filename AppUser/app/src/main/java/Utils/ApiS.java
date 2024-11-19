package Utils;

import retrofit2.http.Url;

public class ApiS {
    public static final String URL="http://10.0.2.2:8080/";
    public static UtilisateurService getService(){
        return Client.getRetrofit(URL).create(UtilisateurService.class);

    }
}
