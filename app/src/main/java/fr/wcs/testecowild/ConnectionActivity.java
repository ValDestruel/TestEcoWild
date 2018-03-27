package fr.wcs.testecowild;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ConnectionActivity extends AppCompatActivity {

    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        final EditText editTextCompte = findViewById(R.id.editText_compte_connection);
        final EditText editTextPassword = findViewById(R.id.editText_password_connection);
        final ImageView imageViewPassword = findViewById(R.id.imageView_password_connection);
        final TextView textViewForgottenPassword = findViewById(R.id.textView_forgotten_password);
        final Button buttonConnection = findViewById(R.id.button);
        final CheckBox checkBoxConnection = findViewById(R.id.checkBox_connection);

        final SharedPreferences sharedPrefCompte = this.getPreferences(Context.MODE_PRIVATE);
        String usernameCache = sharedPrefCompte.getString("username", "");
        editTextCompte.setText(usernameCache);

        final SharedPreferences sharedPreferencesPassword = this.getPreferences(Context.MODE_PRIVATE);
        String passwordCache = sharedPreferencesPassword.getString("password", "");
        editTextPassword.setText(passwordCache);

        imageViewPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i == 1) {
                    editTextPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    i = 2;
                }

                else {
                    editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    i = 1;
                }
            }
        });

        textViewForgottenPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentForgottenPassword = new Intent(ConnectionActivity.this, ForgottenPasswordActivity.class);
                ConnectionActivity.this.startActivity(intentForgottenPassword);
            }
        });

        buttonConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String editCompte = editTextCompte.getText().toString();
                String editPassword = editTextPassword.getText().toString();

                if (editCompte.isEmpty() || editPassword.isEmpty()) {
                    Toast.makeText(ConnectionActivity.this, "Remplissez tous les champs", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent intentMap = new Intent(ConnectionActivity.this, MapActivity.class);
                    ConnectionActivity.this.startActivity(intentMap);
                }

                if (checkBoxConnection.isChecked()) {
                    SharedPreferences.Editor editorCompte = sharedPrefCompte.edit();
                    editorCompte.putString("username", editCompte);
                    editorCompte.commit();

                    SharedPreferences.Editor editorPassword = sharedPrefCompte.edit();
                    editorPassword.putString("password", editPassword);
                    editorPassword.commit();
                }
            }
        });
    }
}
