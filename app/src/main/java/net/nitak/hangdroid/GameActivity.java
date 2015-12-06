package net.nitak.hangdroid;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        if (letter.length() == 1) {
            checkLetter(letter);
        } else {
            Toast.makeText(this, //where
                    "Please Introduce Letter", //what
                    Toast.LENGTH_SHORT).show(); //how
        }

    }


    public void checkLetter(String introducedLetter){

    }
}
