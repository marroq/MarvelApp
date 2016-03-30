package galileo.marvel.dfer.marvelapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import galileo.marvel.dfer.marvelapp.R;

/**
 * Created by dfer on 13/03/16.
 */
public class HeroeAdapterRecycler extends RecyclerView.Adapter<HeroeAdapterRecycler.ViewHolder> {
    private Context context;
    private HashMap<String, List<HeroeRecord>> heroesDataset;
    private List<HeroeRecord> dataset;
    private OnItemClickListener clickListener;

    public HeroeAdapterRecycler(Context context) {
        this.context = context;
        this.heroesDataset = new HashMap<String, List<HeroeRecord>>();
        this.dataset = new ArrayList<HeroeRecord>();
        String[] listHeroes = {"iron man", "spider man", "thor", "hulk", "captain america"};
        for (int i=0;i<listHeroes.length;i++) {
            asignToHereo(listHeroes[i]);
        }
    }

    public void asignToHereo(String heroe) {
        List<HeroeRecord> dataset = new ArrayList<HeroeRecord>();
        String[] power = {"trepar","volar","telaraña","trueno","fuerza"};

        for (int i =0; i<5; i++) {
            HeroeRecord info = new HeroeRecord();
            info.setNameHeroe(heroe);
            info.setHistoryHeroe(power[i]);
            dataset.add(info);
        }

        this.heroesDataset.put(heroe, dataset);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.heroe_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //@Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HeroeRecord element = dataset.get(position);

        //String strHereo = context.getString(R.string.hereoTest);
        //strHereo = String.format(strHereo, element.getNameHeroe());
        holder.lblHeroe.setText(element.getNameHeroe());

        //String strHistoria = context.getString(R.string.descTest);
        //strHistoria = String.format(strHistoria, element.getHistoryHeroe());
        holder.lblHistory.setText(element.getHistoryHeroe());

        if (this.clickListener != null) {
            holder.setOnItemClickListener(element, this.clickListener);
        }
    }

    public void addElement(HeroeRecord element) {
        dataset.add(element);
        notifyDataSetChanged();
    }

    public void filterByHeroe(String heroe) {
        List<HeroeRecord> list = heroesDataset.get(heroe.toLowerCase().trim());
        if (list == null) {
            dataset = new ArrayList<>();
        } else {
            dataset = list;
        }
        notifyDataSetChanged();
    }

    public void clear() {
        dataset.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.lblHeroe) TextView lblHeroe;
        @Bind(R.id.lblHistory) TextView lblHistory;
        private View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            ButterKnife.bind(this, view);
        }

        public void setOnItemClickListener(final HeroeRecord element, final OnItemClickListener listener) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(element);
                    Log.d("HeroeAdapterRecycler", "constructor HeroeAdapterRecycler");
                }
            });
        }
    }
}
