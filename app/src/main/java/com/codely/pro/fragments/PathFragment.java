/**
 *
 */
package com.codely.pro.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codely.pro.R;


/**
 * @author ilia
 */
public class PathFragment extends Fragment {


    public PathFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.path, container, false);

        return rootView;
    }

}
