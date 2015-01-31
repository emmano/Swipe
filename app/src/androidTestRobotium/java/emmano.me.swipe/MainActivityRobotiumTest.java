package emmano.me.swipe;

import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

import emmano.me.swipe.MainActivity;

public class MainActivityRobotiumTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    public MainActivityRobotiumTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testSomeTest() throws Exception {
        assertTrue(solo.searchText("Hello world"));
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}