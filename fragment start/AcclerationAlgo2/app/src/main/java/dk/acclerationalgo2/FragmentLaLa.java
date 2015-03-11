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
public class FragmentLaLa extends SuperFragment implements View.OnClickListener {

    private static final String TAG = "graph";

    public FragmentLaLa() {
    }

    public static FragmentLaLa newInstance() {
        FragmentLaLa fragment = new FragmentLaLa();
        return fragment;
    }

    public MainActivity ma;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lala, container, false);
        ma = (MainActivity)getActivity();

          /* */
        int[] clickButtons = new int[]{R.id.alive
        };
        for (int i : clickButtons) {
            rootView.findViewById(i).setOnClickListener(this);
        }
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId() )
        {
            case R.id.alive:
                Toast.makeText(ma.getApplicationContext(), "I am alive!!!", Toast.LENGTH_SHORT).show();
            break;
        }
        Log.d(TAG, "clicked item.: " + v.getId());
    }

    @Override
    protected boolean canGoBack() {
        return true;
    }
}
