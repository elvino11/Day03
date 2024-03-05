package com.example.day03;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnMove = findViewById(R.id.btnMove);
        Button btnMoveWithData = findViewById(R.id.btnMoveWithData);
        Button btnImplicit = findViewById(R.id.btnImplicit);
        btnMove.setOnClickListener(this);
        btnMoveWithData.setOnClickListener(this);
        btnImplicit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnMove) {
            Intent move = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(move);
        } else if (v.getId() == R.id.btnMoveWithData) {
            String text = "Halo ini saya loh";
            Intent data = new Intent(MainActivity.this, DetailActivity.class);
            data.putExtra(DetailActivity.EXTRA_NAME, text);
            startActivity(data);
        } else if (v.getId() == R.id.btnImplicit) {
            String phoneNumber = "081210841382";
            Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(dialPhoneIntent);
        }

    }
}