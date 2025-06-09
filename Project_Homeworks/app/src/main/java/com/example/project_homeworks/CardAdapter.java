package com.example.project_homeworks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{

    private List<String> cardList;
    private List<String> priceList;

    public CardAdapter(List<String> cardList, List<String> priceList ) {
        this.cardList = cardList;
        this.priceList = priceList;
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_style, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        holder.card_name_view.setText(cardList.get(position));
        holder.card_price_view.setText(priceList.get(position));
        holder.korzina_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardList.remove(position);
                priceList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView card_name_view;
        TextView card_price_view;
        ImageView korzina_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            card_name_view = itemView.findViewById(R.id.textViewTovarName);
            card_price_view = itemView.findViewById(R.id.textViewTovarPrice);
            korzina_view = itemView.findViewById(R.id.korzina_card);
        }
    }
}
