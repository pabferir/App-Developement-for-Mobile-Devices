package com.pabferir.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pabferir.dashboardactivity.R;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void launchIntentFromDashboard(View v) {
        switch (v.getId()) {
            case R.id.dboard_b1:
                Toast.makeText(this, "Button 1 clicked!", Toast.LENGTH_SHORT).show();
                Intent intent_1 = new Intent(this, QuotationActivity.class);
                startActivity(intent_1);
                break;
            case R.id.dboard_b2:
                Toast.makeText(this, "Button 2 clicked!", Toast.LENGTH_SHORT).show();
                Intent intent_2 = new Intent(this, FavouriteActivity.class);
                startActivity(intent_2);
                break;
            case R.id.dboard_b3:
                Toast.makeText(this, "Button 3 clicked!", Toast.LENGTH_SHORT).show();
                Intent intent_3 = new Intent(this, SettingsActivity.class);
                startActivity(intent_3);
                break;
            case R.id.dboard_b4:
                Toast.makeText(this, "Button 4 clicked!", Toast.LENGTH_SHORT).show();
                Intent intent_4 = new Intent(this, AboutActivity.class);
                startActivity(intent_4);
                break;
        }
    }
}
