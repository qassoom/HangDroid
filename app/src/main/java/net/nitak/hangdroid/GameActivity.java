package net.nitak.hangdroid;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class GameActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

    }

    public void introduceLetter(View v){
        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);

        String letter = myEditText.getText().toString();

        Log.d("MYLOG", "The letter is "+letter);


    }

}
