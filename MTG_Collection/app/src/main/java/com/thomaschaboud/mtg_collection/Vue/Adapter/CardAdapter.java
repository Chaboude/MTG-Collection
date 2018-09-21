package com.thomaschaboud.mtg_collection.Vue.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.thomaschaboud.mtg_collection.R;

import java.util.List;

import io.magicthegathering.javasdk.resource.Card;

/**
 * Created by Thomas on 20/09/2018.
 */

public class CardAdapter extends ArrayAdapter<Card> {

    public CardAdapter(Context context, List<Card> objects) {
        super(context,0,objects);
    }

    //region methodee

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listadaptercards, parent, false);
        }

        CardAdapter.ViewHolder viewHolder  = (CardAdapter.ViewHolder) convertView.getTag();

        if (viewHolder == null) {
            viewHolder = new CardAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listadaptercards, parent, false);
            viewHolder.textViewNameCard = convertView.findViewById(R.id.textViewNameCard);
            viewHolder.textViewManaCostCard = convertView.findViewById(R.id.textManaViewCostCard);
            viewHolder.imageViewCard = convertView.findViewById(R.id.imageViewCard);
            convertView.setTag(viewHolder);
        }

        Card card = getItem(position);
        if(card != null){
            viewHolder.textViewNameCard.setText(card.getName());
            viewHolder.textViewManaCostCard.setText(card.getManaCost());
        }

        // ad - Utilisation de Picasso pour afficher les images depuis une URL
        Picasso.with(getContext()).load(card.getImageUrl()).resize(250, 350).into(viewHolder.imageViewCard);

        return convertView;
    }

    //endregion

    //region classe

    private static class ViewHolder{
        TextView textViewNameCard;
        TextView textViewManaCostCard;
        ImageView imageViewCard;
    }

    //endregion
}
