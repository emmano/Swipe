package emmano.me.swipe;

import android.test.ActivityInstrumentationTestCase2;

import emmano.me.swipe.MainActivity;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

public class MainActivityEspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityEspressoTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        getActivity();
    }

    public void testSomeTest() throws Exception {
        onView(withText("Hello world!")).perform(click());
    }
}