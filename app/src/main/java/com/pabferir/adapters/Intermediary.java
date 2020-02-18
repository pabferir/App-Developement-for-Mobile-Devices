package com.pabferir.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pabferir.classes.Quotation;
import com.pabferir.dashboardactivity.R;

import java.util.List;

public class Intermediary extends RecyclerView.Adapter<Intermediary.ViewHolder> {
    private List<Quotation> quotationList;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    public Intermediary(
            List<Quotation> quotationList,
            OnItemClickListener onItemClickListener,
            OnItemLongClickListener onItemLongClickListener
    ) {
        this.quotationList = quotationList;
        this.onItemClickListener = onItemClickListener;
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void removeItemByPosition(int position) {
        quotationList.remove(position);
        notifyItemRemoved(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.quotation_list_row, parent, false
        );
        Intermediary.ViewHolder holder = new ViewHolder(
                view, onItemClickListener, onItemLongClickListener);
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

    public String getAuthorByListPosition(int position) {
        return quotationList.get(position).getQuoteAuthor();
    }

    public interface OnItemClickListener {
        void onItemClickListener(int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClickListener(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView quotationText;
        public TextView quotationAuthor;

        public ViewHolder(
                View view,
                final OnItemClickListener onItemClickListener,
                final OnItemLongClickListener onItemLongClickListener
        ) {
            super(view);
            this.quotationText = (TextView) view.findViewById(R.id.quoteText_label);
            this.quotationAuthor = (TextView) view.findViewById(R.id.quoteAuthor_label);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClickListener(getAdapterPosition());
                }
            });

            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onItemLongClickListener.onItemLongClickListener(getAdapterPosition());
                    return false;
                }
            });
        }
    }
}
