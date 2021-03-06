package circleci.espressosample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.app.Activity;
import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.squareup.spoon.Spoon;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by alexey on 16/12/2015.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testTextChangesWhenButtonIsPressed() {
        Spoon.screenshot(mainActivityActivityTestRule.getActivity(), "start_state");
        onView(withId(R.id.changeTextButton)).perform(click());
        onView(withId(R.id.helloWorldTextView)).check(matches(withText("Text changed!")));
        Spoon.screenshot(mainActivityActivityTestRule.getActivity(), "end_state");
    }

    @Test
    public void testTextTakePic() {
        Spoon.screenshot(mainActivityActivityTestRule.getActivity(), "initial_state");
    }
}
