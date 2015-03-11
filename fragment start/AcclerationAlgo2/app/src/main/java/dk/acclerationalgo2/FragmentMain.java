package dk.acclerationalgo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mads on 23/01/15.
 */
public class FragmentMain extends SuperFragment implements View.OnClickListener {

    private static final String TAG = "PlaceHolderFragment";
    private MainActivity ma;

    public FragmentMain() {
    }
    public static FragmentMain newInstance() {
        FragmentMain fragment = new FragmentMain();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        /* */
        int[] clickButtons = new int[]{R.id.graph, R.id.lala
        };
        for (int i : clickButtons) {
            rootView.findViewById(i).setOnClickListener(this);
        }

        ma = (MainActivity)getActivity();
        return rootView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.graph:
                ma.pushFragment(FragmentGraph.newInstance(),false);
                break;
            case R.id.lala:
                ma.pushFragment( FragmentLaLa.newInstance(), false  );
                break;
        }
    }

    @Override
    protected boolean canGoBack() {
        return true;
    }
}
