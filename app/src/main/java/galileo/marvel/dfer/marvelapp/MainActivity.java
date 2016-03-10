package galileo.marvel.dfer.marvelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText textHeroe;
    Button btHeroe;
    TextView sName;
    TextView sDesc;
    ImageView pHeroe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textHeroe = (EditText) findViewById(R.id.txtHeroe);
        btHeroe = (Button) findViewById(R.id.btnHeroe);
        sName = (TextView) findViewById(R.id.nombre);
        sDesc = (TextView) findViewById(R.id.descripcion);
        pHeroe = (ImageView) findViewById(R.id.imgHeroe);

        btHeroe.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String input = textHeroe.getText().toString();

        if (input.equals("Iron Man")) {
            sName.setText(input);
            sDesc.setText("Wounded, captured and forced to build a weapon by his enemies, " +
                    "billionaire industrialist Tony Stark instead created an advanced suit of " +
                    "armor to save his life and escape captivity. Now with a new outlook on life, " +
                    "Tony uses his money and intelligence to make the world a safer, better place as Iron Man.");
            pHeroe.setImageResource(R.drawable.iron_man);
        }
        /*
        switch(v.getId()) {
            case R.id.btnHeroe:
                Toast.makeText(getApplicationContext(),"Hola Heroe", Toast.LENGTH_SHORT).show();
                break;
        }
        */
    }
}
