package com.thomaschaboud.mtg_collection.AsyncTask;

import android.os.AsyncTask;
import android.os.Bundle;

import com.thomaschaboud.mtg_collection.Vue.Adapter.CardAdapter;
import com.thomaschaboud.mtg_collection.Vue.Fragment.ListCardsFragment;

import java.util.ArrayList;
import java.util.List;

import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;

/**
 * Created by Thomas on 23/07/2018.
 */

public class CardsAsync extends AsyncTask<Object,Void,ListCardsFragment> {

    //region variables

    private CardAdapter cardAdapter;
    private ArrayList<String> as;
    private List<Card> listCards;
    private ListCardsFragment callback;
    private Bundle args;

    //endregion

    @Override
    protected void onPostExecute(ListCardsFragment call) {
        super.onPostExecute(call);
        call.Refresh(listCards);
        //cardAdapter.notifyDataSetChanged();
    }

    @Override
    protected ListCardsFragment doInBackground(Object... objects) {
        cardAdapter = (CardAdapter) objects[0];
        listCards = (List<Card>) objects[1];
        callback = (ListCardsFragment) objects[2];
        args = callback.getArguments();
        as = args.getStringArrayList("typeCard");
        //as.add("subtypes=god");
        listCards = CardAPI.getAllCards(as);
        return callback;
    }
}
