package fr.wcs.testecowild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonConnect = findViewById(R.id.button_connect);
        buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentConnect = new Intent(MainActivity.this, ConnectionActivity.class);
                startActivity(intentConnect);
            }
        });

        final Button buttonMember = findViewById(R.id.button_member);
        buttonMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMember = new Intent(MainActivity.this, MemberActivity.class);
                MainActivity.this.startActivity(intentMember);
            }
        });
    }
}
