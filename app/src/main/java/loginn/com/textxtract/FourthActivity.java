package loginn.com.textxtract;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        ImageView demoImage = (ImageView) findViewById(R.id.img1);
        int imagesToShow[] = {R.drawable.s22,R.drawable.g5,R.drawable.img4,R.drawable.l66,R.drawable.l77,R.drawable.l88,R.drawable.g1,R.drawable.g7};
        TextView t1=(TextView)findViewById(R.id.t1);
        t1.setText("TextXtract is an application that assists you in extracting any desired text u want from any kind of books,Images,UI's,etc.The extracted text can also be further edited accroding to your own choice.For any queries further visit the Contact page so that we can assist your problems better.");
        t1.setTextSize(15);
        getSupportActionBar().hide();

        animate(demoImage, imagesToShow, 0,true);
    }


    private void animate(final ImageView imageView, final int images[], final int imageIndex, final boolean forever) {

        int fadeInDuration = 500;
        int timeBetween = 2000;
        int fadeOutDuration = 500;

        imageView.setVisibility(View.INVISIBLE);
        imageView.setImageResource(images[imageIndex]);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(fadeInDuration);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setStartOffset(fadeInDuration + timeBetween);
        fadeOut.setDuration(fadeOutDuration);

        AnimationSet animation = new AnimationSet(false);
        animation.addAnimation(fadeIn);
        animation.addAnimation(fadeOut);
        animation.setRepeatCount(1);
        imageView.setAnimation(animation);


        animation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (images.length - 1 > imageIndex) {
                    animate(imageView, images, imageIndex + 1,forever);
                }
                else {
                    if (forever){
                        animate(imageView, images, 0,forever);
                    }
                }
            }
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }
        });
    }


    }


