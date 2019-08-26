package com.example.robolectrictest;


import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void clickingLogin_shouldStartLoginActivity() {
    MainActivity activity = Robolectric.setupActivity(MainActivity.class);
    activity.findViewById(R.id.btn).performClick();

    Intent expectedIntent = new Intent(activity, LoginActivity.class);
    Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
    assertEquals(expectedIntent.getComponent(), actual.getComponent());
}

    @Test
    public void clickingButton_shouldChangeResultsViewText() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.btn);
        TextView results = (TextView) activity.findViewById(R.id.results_text_view);

        button.performClick();
        assertThat(results.getText().toString(), equalTo("Testing Android Rocks!"));
    }

}
