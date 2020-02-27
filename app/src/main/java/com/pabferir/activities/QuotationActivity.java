package com.pabferir.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.pabferir.dashboardactivity.R;

public class QuotationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotation);

        TextView quotationView = (TextView)findViewById(R.id.quotation_quote_tv);
        String quote = getResources().getString(R.string.quotes_label_tv1,
                getResources().getString(R.string.user_defaultName));

        quotationView.setText(quote);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.quotation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                return true;

            case R.id.menu_refresh:
                newQuotation((TextView)findViewById(R.id.quotation_quote_tv));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void newQuotation(View v) {
        TextView quotationView = (TextView)findViewById(R.id.quotation_quote_tv);
        quotationView.setText(R.string.quotes_label_sampleQuote);

        TextView authorView = (TextView) findViewById(R.id.quotation_author_tv);
        authorView.setText(R.string.quotes_label_sampleAuthor);
    }
}
