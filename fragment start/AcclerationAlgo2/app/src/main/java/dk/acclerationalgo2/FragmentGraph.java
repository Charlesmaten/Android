package dk.acclerationalgo2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mads on 14/01/15.
 */
public class FragmentGraph extends SuperFragment implements View.OnClickListener {

    private static final String TAG = "graph";

    public FragmentGraph() {
    }

    public static FragmentGraph newInstance() {
        FragmentGraph fragment = new FragmentGraph();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmentgraf, container, false);

        return rootView;
    }

    @Override
    public void onClick(View v) {


        Log.d(TAG, "clicked item.: " + v.getId());
    }

    @Override
    protected boolean canGoBack() {
        return true;
    }
}
