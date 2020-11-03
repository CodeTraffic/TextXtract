package loginn.com.textxtract;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context){
        this.context=context;
    }

    public int[] slide_images={
            R.drawable.jj,
            R.drawable.bg2,
            R.drawable.c3,
            R.drawable.op

    };

    public String[] slide_headings={
            " Select Gallery",
            "Choose Your Photo",
            "Click On Extract Text",
            "             Click on Camera Icon"
    };


    public String[] slide_desc={
            "Click On Gallery Icon to select image for extracting text from it",
            "        Select Image from Gallery",
            "Click on Extract Button to begin the extracting process",
            "Click on Camera Icon to open Camera View"
    };
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView=(ImageView)view.findViewById(R.id.imageView);
        TextView slideHeading=(TextView)view.findViewById(R.id.textView);
        TextView slideDescription=(TextView)view.findViewById(R.id.tv2);


        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desc[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);


    }
}
