package com.thomaschaboud.mtg_collection.Vue.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.thomaschaboud.mtg_collection.AsyncTask.CardsAsync;
import com.thomaschaboud.mtg_collection.R;
import com.thomaschaboud.mtg_collection.Vue.Adapter.CardAdapter;
import java.util.ArrayList;
import java.util.List;

import io.magicthegathering.javasdk.resource.Card;

/**
 * Created by Thomas on 20/09/2018.
 */

public class ListCardsFragment extends BaseFragment{

    //region variables

    private String typeCard;
    private View v;
    private ListView listViewCards;
    private CardAdapter cardAdapter;
    private List<Card> listCards;

    //endregion

    public ListCardsFragment() {
    }

    public static ListCardsFragment newInstance(ArrayList<String> typeCard) {
        Bundle args = new Bundle();
        ListCardsFragment fragment = new ListCardsFragment();
        args.putStringArrayList("typeCard", typeCard);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater pInflater, ViewGroup pContainer, Bundle savedInstanceState) {
        v = pInflater.inflate(R.layout.fragment_list_cards, pContainer, false);
        listViewCards = (ListView) v.findViewById(R.id.listViewCards);
        listCards = new ArrayList<>();
        cardAdapter = new CardAdapter(getActivity(), listCards);
        new CardsAsync().execute(cardAdapter, listCards, this);

        return v;

    }

    public void Refresh(final List<Card> pListCards){
        CardAdapter adapter  = new CardAdapter(getActivity(), pListCards);
        listViewCards = (ListView) v.findViewById(R.id.listViewCards);
        listViewCards.setAdapter(adapter);

    }
}
