package com.pabferir.dashboardactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

    public void newQuotation(View v) {
        TextView quotationView = (TextView)findViewById(R.id.quotation_quote_tv);
        quotationView.setText(R.string.quotes_label_sampleQuote);

        TextView authorView = (TextView) findViewById(R.id.quotation_author_tv);
        authorView.setText(R.string.quotes_label_sampleAuthor);
    }
}
