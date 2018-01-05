package bookapp.bestapp.com.fragmentproject.activities;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import bookapp.bestapp.com.fragmentproject.MainInterface;
import bookapp.bestapp.com.fragmentproject.R;
import bookapp.bestapp.com.fragmentproject.fragments.ArticleFragment;

public class MainActivity extends AppCompatActivity implements ArticleFragment.OnFragmentInteractionListener{
    private Button button_submit;
    private EditText editText;
    MainInterface mainInterface;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        button_submit = findViewById(R.id.button_submit);
        editText = findViewById(R.id.edit_query);

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainInterface = new ArticleFragment();
                mainInterface.addItem(editText.getText().toString(),context);
            }
        });


        if(findViewById(R.id.fragment_container) != null){

            if(savedInstanceState != null)
                return;

            ArticleFragment articleFragment = new ArticleFragment();

            articleFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container,articleFragment).commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onItemClick(int position, String name) {
        TextView textView = findViewById(R.id.text_view);

        textView.setText(name);
    }


}
