package com.saywhat.firstapp.Home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.saywhat.firstapp.R;
import com.saywhat.firstapp.contact_us.ContactActivity;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {
    private TextView greetingText;
    private ImageView imageView, arrowLeft, arrowRight;

    private int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3};
    private int currentIdx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        greetingText = findViewById(R.id.greeting_text);
        imageView = findViewById(R.id.image_view);
        arrowLeft = findViewById(R.id.arrow_left);
        arrowRight = findViewById(R.id.arrow_right);

        String receivedEmail = getIntent().getStringExtra("email");
        greetingText.setText("Hello, " + receivedEmail.substring(0, 5) + "!");

        imageView.setImageResource(images[currentIdx]);

        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIdx > 0) {
                    currentIdx--;
                } else {
                    currentIdx = images.length - 1;
                }
                imageView.setImageResource(images[currentIdx]);
            }
        });
        arrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIdx < images.length - 1) {
                    currentIdx++;
                } else {
                    currentIdx = 0;
                }
                imageView.setImageResource(images[currentIdx]);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.sub1) {
            Toast.makeText(this, "item1", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.sub2) {
            Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.menu_settings) {
            Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.menu_contact_us) {
            Intent intent = new Intent(HomeActivity.this, ContactActivity.class);
            startActivity(intent);
        } else {
            finish();
        }

        return true;
    }
}