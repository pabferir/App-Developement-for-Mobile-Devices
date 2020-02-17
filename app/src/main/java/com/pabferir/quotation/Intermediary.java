package com.pabferir.quotation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pabferir.dashboardactivity.R;

import java.util.List;

public class Intermediary extends RecyclerView.Adapter<Intermediary.ViewHolder> {
    private List<Quotation> quotationList;

    public Intermediary(List<Quotation> quotationList) {
        this.quotationList = quotationList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView quotationText;
        public TextView quotationAuthor;

        public ViewHolder(View view) {
            super(view);
            this.quotationText = (TextView) view.findViewById(R.id.quoteText_label);
            this.quotationAuthor = (TextView) view.findViewById(R.id.quoteAuthor_label);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.quotation_list_row, parent, false
        );
        Intermediary.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return quotationList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.quotationText.setText(quotationList.get(position).getQuoteText());
        holder.quotationAuthor.setText(quotationList.get(position).getQuoteAuthor());
    }
}
