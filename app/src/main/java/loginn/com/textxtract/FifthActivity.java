package loginn.com.textxtract;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class FifthActivity extends AppCompatActivity {
    private ViewPager pager1;
    private LinearLayout layout1;
    private SliderAdapter sliderAdapter;
    private TextView[] mdots;
private Button nb;
private Button pb;
    private int mCurrentPage;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        pager1 = (ViewPager) findViewById(R.id.pager1);
        layout1 = (LinearLayout) findViewById(R.id.layout1);
        sliderAdapter = new SliderAdapter(this);
        pager1.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        pager1.addOnPageChangeListener(viewListner);
        nb=(Button)findViewById(R.id.b2);
        pb=(Button)findViewById(R.id.b1);
        nb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager1.setCurrentItem(mCurrentPage+1);
            }
        });


        pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager1.setCurrentItem(mCurrentPage-1);
            }
        });

    }

    public void addDotsIndicator(int position) {
        mdots = new TextView[4];
        layout1.removeAllViews();
        for (int i = 0; i < mdots.length; i++) {
            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226;"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.com_facebook_blue));
            layout1.addView(mdots[i]);
        }
        if (mdots.length > 0) {

            mdots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }

    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPage=position;
            if(position==0)
            {
               nb.setEnabled(true);
                pb.setEnabled(false);
                pb.setVisibility(View.INVISIBLE);
                nb.setText("Next");
                pb.setText("");
            }else if(position==mdots.length-1){

                nb.setEnabled(true);
                pb.setEnabled(true);
                pb.setVisibility(View.VISIBLE);
                nb.setText("Finish");
                pb.setText("Back");

            }else{

                nb.setEnabled(true);
                pb.setEnabled(true);
                pb.setVisibility(View.VISIBLE);
                nb.setText("Next");
                pb.setText("Back");

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
