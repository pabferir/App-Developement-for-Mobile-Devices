package com.pabferir.dashboardactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class FavouriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
    }

    public void getAuthorInfo(View v) {
        String authorName = "Albert Einstein";

        Uri wikipedia = Uri.parse("https://en.wikipedia.org/wiki/Special:Search?search=" + authorName);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, wikipedia);
        startActivity(webIntent);
    }
}
