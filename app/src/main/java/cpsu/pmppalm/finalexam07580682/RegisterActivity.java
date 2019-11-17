package cpsu.pmppalm.finalexam07580682;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cpsu.pmppalm.finalexam07580682.Database.UserManager;
import cpsu.pmppalm.finalexam07580682.model.User;

public class RegisterActivity extends AppCompatActivity {
    private EditText mUsername;
    private EditText mFullname;
    private EditText mPassword;
    private Button mRegister;

    private Context mContext;
    private UserManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mManager = new UserManager(this);
        mContext = this;
        mFullname = findViewById(R.id.full_name_edit_text);
        mUsername = findViewById(R.id.username_edit_text);
        mPassword = findViewById(R.id.password_edit_text);

        mRegister = findViewById(R.id.register_button);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String fullname = mFullname.getText().toString();
                String username = mUsername.getText().toString().trim().toLowerCase();
                String password = mPassword.getText().toString();


                User user = new User(username, password);
                long rowId = mManager.registerUser(user);



                    if (TextUtils.isEmpty(mUsername.getText()) && TextUtils.isEmpty(mPassword.getText()) && TextUtils.isEmpty(mFullname.getText())) {
                        Toast.makeText(mContext, "All fields are required", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(mContext, "Register successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }

                }


        });
    }
}
