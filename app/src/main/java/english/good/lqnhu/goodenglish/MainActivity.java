package english.good.lqnhu.goodenglish;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.matthewlogan.circlemenu.library.CircleMenu;

import lqnhu.english.good.ui.R;

public class MainActivity extends Activity implements View.OnClickListener , CircleMenu.OnItemClickListener {

    private static int[] sBackgroundImages = new int[] {
            R.drawable.hawk_landing_on_post,
            R.drawable.walla_walla_skateboarder,
            R.drawable.windmills,
            R.drawable.hawk_landing_on_post
    };

    private static String[] sBackgroundImageNames = new String[] {
            "Viết email theo mẫu",
            "Giao tiếp theo tình huống",
            "Các từ thường gặp hàng ngày",
            "Luyện nghe cơ bản"
    };

    private int mCurrentPosition;

    private View mMenuButton;
    private CircleMenu mCircleMenu;
    private ImageView mBackgroundImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMenuButton = findViewById(R.id.menu_button);
        mCircleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        mBackgroundImageView = (ImageView) findViewById(R.id.background_image);

        mMenuButton.setOnClickListener(this);

        mCircleMenu.setOnItemClickListener(this);
        mCircleMenu.setItems(sBackgroundImageNames);

        if (savedInstanceState != null) {
            setBackgroundImage(savedInstanceState.getInt("currentPosition"));
        }
        mCircleMenu.toggle();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("currentPosition", mCurrentPosition);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        mCircleMenu.toggle();
    }

    @Override
    public void onItemClick(int position) {
        setBackgroundImage(position);
    }
    private void setBackgroundImage(int position) {
        mBackgroundImageView.setImageDrawable( getResources().getDrawable(sBackgroundImages[position]));
        mCurrentPosition = position;
    }

}
