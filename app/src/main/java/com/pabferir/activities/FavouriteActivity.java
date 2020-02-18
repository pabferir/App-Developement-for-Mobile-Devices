package com.pabferir.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.pabferir.adapters.Intermediary;
import com.pabferir.classes.Quotation;
import com.pabferir.dashboardactivity.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {

    Intermediary intermediary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        final RecyclerView recycler = findViewById(R.id.activityFavs_recycler);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false
        );
        recycler.setLayoutManager(manager);

        intermediary = new Intermediary(
                getMockQuotations(),
                new Intermediary.OnItemClickListener() {
                    @Override
                    public void onItemClickListener(int position) {
                        getAuthorInfo(position);
                    }
                },
                new Intermediary.OnItemLongClickListener() {
                    @Override
                    public void onItemLongClickListener(final int position) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(recycler.getContext());
                        builder.setIcon(android.R.drawable.stat_sys_warning);
                        builder.setTitle(R.string.favs_dialog_title);
                        builder.setMessage(R.string.favs_dialog_message);
                        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                intermediary.removeItemByPosition(position);
                            }
                        });
                        builder.setNegativeButton(android.R.string.no, null);
                        builder.create().show();
                    }
                }
        );
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
        );
        recycler.setAdapter(intermediary);
        recycler.addItemDecoration(decoration);
    }

    public void getAuthorInfo(int position) {
        String authorName = null;
        try {
            authorName = URLEncoder.encode(intermediary.getAuthorByListPosition(position), "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Uri wikipedia = Uri.parse("https://en.wikipedia.org/wiki/Special:Search?search=" + authorName);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, wikipedia);
        startActivity(webIntent);
    }

    public ArrayList<Quotation> getMockQuotations() {
        ArrayList<Quotation> list = new ArrayList<>();
        //Quotation sampleQuotation = new Quotation(
        //        "This is a sample quote",
        //        "Sample Author"
        //);
        for(int i = 0; i < 10; i++) list.add(
                new Quotation(
                        "This is a sample quote " + i,
                        "Sample Author"
                )
        );
        return list;
    }
}
