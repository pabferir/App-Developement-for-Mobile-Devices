package com.pabferir.dashboardactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.pabferir.quotation.Intermediary;
import com.pabferir.quotation.Quotation;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        RecyclerView recycler = findViewById(R.id.activityFavs_recycler);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false
        );
        recycler.setLayoutManager(manager);

        Intermediary intermediary = new Intermediary(getMockQuotations());
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
        );
        recycler.setAdapter(intermediary);
        recycler.addItemDecoration(decoration);
    }

    public void getAuthorInfo(View v) {
        String authorName = "Albert Einstein";

        Uri wikipedia = Uri.parse("https://en.wikipedia.org/wiki/Special:Search?search=" + authorName);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, wikipedia);
        startActivity(webIntent);
    }

    public ArrayList<Quotation> getMockQuotations() {
        ArrayList<Quotation> list = new ArrayList<>();
        Quotation sampleQuotation = new Quotation(
                "This is a sample quote",
                "Sample Author"
        );
        for(int i = 0; i < 10; i++) list.add(sampleQuotation);
        return list;
    }
}
