package dk.acclerationalgo2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by mads on 14/01/15.
 */
public class Fragment_lalala extends SuperFragment implements View.OnClickListener {

    private static final String TAG = "graph";
    private MainActivity ma;

    public Fragment_lalala() {
    }

    public static Fragment_lalala newInstance() {
        Fragment_lalala fragment = new Fragment_lalala();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lalala, container, false);

        ma = (MainActivity) getActivity();

        int[] clickButtons = new int[]{R.id.graph,R.id.thisisabutton
        };
        for (int i : clickButtons) {
            rootView.findViewById(i).setOnClickListener(this);
        }
        return rootView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.thisisabutton:
                //do stuff
                Toast.makeText(ma, "dette er en toast",Toast.LENGTH_SHORT).show();
                break;
        }

        Log.d(TAG, "clicked item.: " + v.getId());
    }

    @Override
    protected boolean canGoBack() {
        return true;
    }
}
