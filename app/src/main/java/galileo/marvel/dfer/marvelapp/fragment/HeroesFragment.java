package galileo.marvel.dfer.marvelapp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import galileo.marvel.dfer.marvelapp.R;
import galileo.marvel.dfer.marvelapp.activities.HereoDetailActivity;
import galileo.marvel.dfer.marvelapp.adapter.HeroeAdapterRecycler;
import galileo.marvel.dfer.marvelapp.adapter.HeroeRecord;
import galileo.marvel.dfer.marvelapp.adapter.OnItemClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class HeroesFragment extends Fragment implements HeroesFragmentListener, OnItemClickListener {
    @Bind(R.id.recyclerView) RecyclerView recyclerView;
    @Bind(R.id.heroeTitle) TextView heroeTitle;
    private HeroeAdapterRecycler adapter;

    public HeroesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_heroes, container, false);
        ButterKnife.bind(this, view);
        initAdapter();
        initRecyclerView();
        return view;
    }

    private void initAdapter() {
        if (adapter==null) {
            adapter = new HeroeAdapterRecycler(getActivity().getApplicationContext());
            adapter.setOnItemClickListener(this);
        }
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void addToList(HeroeRecord record) {
        adapter.addElement(record);
    }

    @Override
    public void onItemClick(HeroeRecord element) {
        Intent intent = new Intent(getActivity(), HereoDetailActivity.class);

        //intent.putExtra(HereoDetailActivity.HR, element.getNameHeroe());
        //intent.putExtra(HereoDetailActivity.DESC, element.getHistoryHeroe());
        
        startActivity(intent);
    }

    public void searchHeroe(String heroe) {
        this.heroeTitle.setText(heroe.toUpperCase());
        adapter.filterByHeroe(heroe);
    }
}
