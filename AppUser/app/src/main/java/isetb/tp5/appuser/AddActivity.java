package isetb.tp5.appuser;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Model.User;
import Utils.ApiS;
import Utils.UtilisateurService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {

    EditText editFirstName, editLastName, editEmail, editAge;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // Initialize views
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        editAge = findViewById(R.id.editAge);
        btnSave = findViewById(R.id.btnSave);

        // Set Save button click listener
        btnSave.setOnClickListener(v -> {
            String firstName = editFirstName.getText().toString().trim();
            String lastName = editLastName.getText().toString().trim();
            String email = editEmail.getText().toString().trim();
            String ageString = editAge.getText().toString().trim();

            if (validateInputs(firstName, lastName, email, ageString)) {
                int age = Integer.parseInt(ageString);
                addUserToDatabase(firstName, lastName, email, age);
            }
        });
    }

    private boolean validateInputs(String firstName, String lastName, String email, String ageString) {
        if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) ||
                TextUtils.isEmpty(email) || TextUtils.isEmpty(ageString)) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void addUserToDatabase(String firstName, String lastName, String email, int age) {
        UtilisateurService apiService = ApiS.getService();
        User user = new User(firstName, lastName, email, age);

        Call<Void> call = apiService.addUser(user);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(AddActivity.this, "User added successfully", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    String errorMessage = "Failed to add user. Code: " + response.code();
                    try {
                        errorMessage += ", Error Body: " + response.errorBody().string();
                    } catch (Exception e) {
                        errorMessage += ", Error: " + e.getMessage();
                    }
                    Toast.makeText(AddActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(AddActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
