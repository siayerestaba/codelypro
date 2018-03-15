/**
 *
 */
package com.codely.pro.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codely.pro.R;
import com.codely.pro.custom.ImageService;


/**
 * @author ilia
 */
public class AboutFragment extends Fragment {

    private TextView summaryTitle;
    private TextView summary;

    private TextView descTitle;
    private TextView description;

    private TextView aboutTitle;
    private LinearLayout about;

    public AboutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.about, container, false);

        initTextview(rootView);

        return rootView;
    }

    private void initTextview(View rootView) {
        summaryTitle = rootView.findViewById(R.id.title_summary);
        summaryTitle.setOnClickListener(summaryListener);

        descTitle = rootView.findViewById(R.id.title_description);
        descTitle.setOnClickListener(descriptionListener);

        aboutTitle = rootView.findViewById(R.id.title_about);
        aboutTitle.setOnClickListener(aboutListener);

        summary = rootView.findViewById(R.id.summary);
        description = rootView.findViewById(R.id.description);

        about = rootView.findViewById(R.id.about);

        ImageView photo = rootView.findViewById(R.id.about_photo);
        Bitmap bitmap = ImageService.getCircleBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ilia));
        photo.setImageBitmap(bitmap);
    }

    private View.OnClickListener summaryListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (summary.getVisibility() == View.VISIBLE) {
                summary.setVisibility(View.GONE);
                summaryTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_moreinfo, 0);
            } else {
                summary.setVisibility(View.VISIBLE);
                summaryTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_lessinfo, 0);
            }
        }
    };

    private View.OnClickListener descriptionListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (description.getVisibility() == View.VISIBLE) {
                description.setVisibility(View.GONE);
                descTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_moreinfo, 0);
            } else {
                description.setVisibility(View.VISIBLE);
                descTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_lessinfo, 0);
            }
        }
    };

    private View.OnClickListener aboutListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (about.getVisibility() == View.VISIBLE) {
                about.setVisibility(View.GONE);
                aboutTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_moreinfo, 0);
            } else {
                about.setVisibility(View.VISIBLE);
                aboutTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_lessinfo, 0);
            }
        }
    };
}
