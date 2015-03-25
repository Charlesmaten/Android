package com.example.asynctaskdemo10;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author Prabu, Peter Lorensen
 * 
 * -int and seconds is used that is then converted into milliseconds and later split in two. 
 * This will cause rounding errors and will show up as inaccuracy when sleeping for odd numbers.
 * 
 */
public class MainActivity extends Activity implements View.OnClickListener {
	private Button buttonRunAsync;
    private Button buttonDummy;
    private RelativeLayout layoutBack;
	private EditText time;
	private TextView textView_finalResult;
	private boolean isCyan;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Initializing:
		time = (EditText) findViewById(R.id.et_time);
        buttonRunAsync = (Button) findViewById(R.id.btn_runAsync);
        buttonRunAsync.setOnClickListener(this);
        buttonDummy = (Button) findViewById(R.id.btn_dummy);
        buttonDummy.setOnClickListener(this);
		textView_finalResult = (TextView) findViewById(R.id.tv_result);
        layoutBack = (RelativeLayout)findViewById(R.id.relative_layout);
		isCyan = false;
	}

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dummy: //Dummy button switches background color
                if(isCyan){
                    layoutBack.setBackgroundColor(Color.LTGRAY);
                    isCyan = false;
                }
                else{
                    layoutBack.setBackgroundColor(Color.CYAN);
                    isCyan = true;
                }
             break;

            case R.id.btn_runAsync:
                AsyncTaskSleeper runner = new AsyncTaskSleeper(); // Creating instance of class
                String sleepTime = time.getText().toString(); // Getting the info from user
                runner.execute(sleepTime); // running the asyncTask with the user specified sleep time
                textView_finalResult.setText("Sleeping for " + (Integer.parseInt(sleepTime)) + " seconds");
            break;
        }
    }

    /**
	 * < String, String, String > Indicates what TYPE of parameters are used in this class.
	 *  
	 * 1. String: String is the TYPE of parameter pass into the doInBackGround() method
	 * 2. String: String is the TYPE of parameter that must be passed into the publishProgress(String) method and the
	 *    onProgressUpdate(String) method. 
	 * 3. String: String is the TYPE of parameter passed to the onPostExecute(String) method.
	 */
	private class AsyncTaskSleeper extends AsyncTask<String, String, String> {

		

		@Override
		protected String doInBackground(String... params) {			
			String resp = "";
			try {
				// Do your long operations here and return the result
				int totalTime = Integer.parseInt(params[0])*1000; //Picking out the 1st parameter (=the user time), converting to int and * 1000 to make miliseconds (=needed for the sleep() method)

				Thread.sleep(totalTime/2); // Sleeping for given time period. Changed to milliseconds.
                publishProgress("Half way there");
                Thread.sleep(totalTime/2);
			} catch (Exception e) {
				e.printStackTrace();
				resp = e.getMessage();
			}
			return resp ;



	}//End doinbackground

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            textView_finalResult.setText(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView_finalResult.setText(s);
        }
    }// End asyncTaskClass


}
