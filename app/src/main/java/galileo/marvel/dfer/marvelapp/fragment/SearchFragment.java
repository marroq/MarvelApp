package galileo.marvel.dfer.marvelapp.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import galileo.marvel.dfer.marvelapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.txtHeroe) EditText txtHeroe;
    @Bind(R.id.btnHeroe) Button btnHeroe;
    SearchFragmentListener communication;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);
        btnHeroe.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnHeroe) {
            Log.d("onClick", "onClick:" + txtHeroe.getText().toString());
            if (this.communication != null && txtHeroe.getText().toString().length()>0) {
                this.communication.searchHereo(txtHeroe.getText().toString());
            }
        }
    }
    
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof SearchFragmentListener) {
            this.communication = (SearchFragmentListener)context;
        }
    }

    @Override
    public void  onResume() {
        super.onResume();
        if (this.communication != null && txtHeroe.getText().toString().length() > 0) {
            this.communication.searchHereo(txtHeroe.getText().toString());
        }
    }
}
