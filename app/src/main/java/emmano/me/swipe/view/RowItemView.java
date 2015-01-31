package emmano.me.swipe.view;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import emmano.me.swipe.R;

/**
 * Created by emmanuelortiguela on 1/31/15.
 */
public class RowItemView extends RelativeLayout implements View.OnTouchListener {

    @InjectView(R.id.strikeTextView)
    protected TextView strikeTextView;
    
    @InjectView(R.id.avatar)
    protected ImageView avatar;

    private GestureDetectorCompat gestureDetector;

    public RowItemView(Context context) {
        super(context);
        init();
    }
    
    public void setPaymentDescription(String description){
        strikeTextView.setText(description);
        
    }
    
    public void setAvatar(String url){
        Picasso.with(getContext()).load(url).into(avatar);
    }

    private void init() {
        inflate(getContext(), R.layout.row_layout, this);
        ButterKnife.inject(this);
        gestureDetector = new GestureDetectorCompat(getContext(), new CustomGestureDetector());
        setLongClickable(true);
        setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return gestureDetector.onTouchEvent(event);
    }


    private class CustomGestureDetector extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if (velocityX > 40) {
                strikeTextView.setPaintFlags(
                        strikeTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                return true;
            }
            
            if (velocityX < -40) {
                strikeTextView.setPaintFlags(
                        strikeTextView.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                return true;
            }
            return false;
        }
    }
}
