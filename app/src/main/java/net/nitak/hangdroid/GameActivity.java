package net.nitak.hangdroid;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {

    String mWord = "WORD";

    int mFailsCounter = 0;

    int correctlyGuessedLetters = 0;

    int tryCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

    }

    public void introduceLetter(View v){
        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);
        String letter = myEditText.getText().toString();
        myEditText.setText("");

        Log.d("MYLOG", "The letter we are checking now is " + letter);

        if (letter.length() == 1) {
            checkLetter(letter);
        } else {
            Toast.makeText(this, //where
                    "Please Introduce Letter", //what
                    Toast.LENGTH_SHORT).show(); //how
        }

    }


    /*public void clickedLetter(View v){
        EditText theClickedLetter =
        //TODO Fix this!
    }
    */

    /**
     * Checking if the letter introduced matches any letter in teh word to guess
     * @param introducedLetter , letter introduced by the user
     */




    public void checkLetter(String introducedLetter) {

        tryCounter++;
        Log.d("MYLOG", "Number of attempts: " + tryCounter);


        char charIntroduced = introducedLetter.charAt(0);

        boolean letterGuessed = false;


        for (int i = 0; i < mWord.length(); i++) {

            char charFromTheWord = mWord.charAt(i);

            Log.d("MYLOG", "The letter we are checking against is " + charFromTheWord);


            if (charFromTheWord == charIntroduced) {

                //TODO SHOW the letters

                Log.d("MYLOG", "There was a match! The typed letter is " + charIntroduced);
                showLettersAtIndex(i, charIntroduced);

                letterGuessed = true;

                correctlyGuessedLetters++;
            }

            //Executed

        }
        if (letterGuessed == false) {
            letterFailed(charIntroduced);
        }


        if (correctlyGuessedLetters == mWord.length()) {
            //TODO Score a Point

            //TODO Start the game!
            clearScreen();
        }

    }
        public void clearScreen(){

            LinearLayout failedLinearLayout = (LinearLayout) findViewById(R.id.failedLettersLayout);
            LinearLayout successfulLinearLayout = (LinearLayout) findViewById(R.id.sucessfulLettersLayout);

            correctlyGuessedLetters = 0;
            mFailsCounter = 0;

            ImageView imageView = (ImageView) findViewById(R.id.imageView);

            imageView.setImageResource(R.drawable.hangdroid_0_0);


            for (int i=0; i < failedLinearLayout.getChildCount(); i++) {

                TextView currentTextView = (TextView) failedLinearLayout.getChildAt(i);
                currentTextView.setText("_");
            }


            for (int i=0; i < successfulLinearLayout.getChildCount(); i++){

                TextView currentTextView = (TextView) successfulLinearLayout.getChildAt(i);
                currentTextView.setText("_");

            }


        /*

        TextView failedLetter1View = (TextView) findViewById(R.id.failedLetter1);
        failedLetter1View.setText("_");

        TextView failedLetter2View = (TextView) findViewById(R.id.failedLetter2);
        failedLetter2View.setText("_");

        TextView failedLetter3View = (TextView) findViewById(R.id.failedLetter3);
        failedLetter3View.setText("_");

        TextView failedLetter4View = (TextView) findViewById(R.id.failedLetter4);
        failedLetter4View.setText("_");

        TextView failedLetter5View = (TextView) findViewById(R.id.failedLetter4);
        failedLetter5View.setText("_");

        */






        }





    public void letterFailed(char charIntroduced) {



        LinearLayout failedLinearLayout = (LinearLayout) findViewById(R.id.failedLettersLayout);


        TextView textView = (TextView) failedLinearLayout.getChildAt(mFailsCounter);

        textView.setText(Character.toString(charIntroduced));

        mFailsCounter++;




        Log.d("MYLOG", "Fail Counter at "+mFailsCounter);



        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        if (mFailsCounter == 1) {
            imageView.setImageResource(R.drawable.hangdroid_1);

        } else if (mFailsCounter == 2) {
            imageView.setImageResource(R.drawable.hangdroid_2);
        } else if (mFailsCounter == 3) {
            imageView.setImageResource(R.drawable.hangdroid_3);
        } else if (mFailsCounter == 4) {
            imageView.setImageResource(R.drawable.hangdroid_4);
        } else if (mFailsCounter == 5) {
            imageView.setImageResource(R.drawable.hangdroid_5);
        } else if (mFailsCounter == 6) {
            imageView.setImageResource(R.drawable.game_over);

            // TODO Game Over! :-)
        }


        //imageView.setImage


    }




    /**
     *
     * Displaying a letter guessed by the user
     *
     * @param position of the letter
     * @param letterGuessed
     */
    public void showLettersAtIndex(int position, char letterGuessed){
        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.sucessfulLettersLayout);

        TextView textView = (TextView) layoutLetter.getChildAt(position);

        textView.setText(Character.toString(letterGuessed));


    }

}
