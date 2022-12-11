package com.example.calculator
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CalculatorInstrumentationTest {
  @get:Rule()
  val activity = ActivityScenarioRule(MainActivity::class.java)

  @Test
  fun calculate_20_percent_tip(){
    onView(withId(R.id.cost_of_service))
      .perform(typeText("50.00"))
      .perform(closeSoftKeyboard())

    //click the button
    onView(withId(R.id.calculate_button))
      .perform(click())

    onView(withId(R.id.tip_result))
      .check(matches(withText(containsString("$10.00"))))

  }

  @Test
  fun calculate_15_percent_and_round_tip(){
    //add a cost
    onView(withId(R.id.cost_of_service))
      .perform(typeText("53.00"))
      .perform(closeSoftKeyboard())
    //select percentage
    onView(withId(R.id.option_fifteen_percent))
      .perform(click())
      .check(matches(isChecked()))
    //make tip roundable
//    onView(withId(R.id.round_up_switch))
//      .perform(click())
    //calculate
    //click the button
    onView(withId(R.id.calculate_button))
      .perform(click())
    //final
    onView(withId(R.id.tip_result))
      .check(matches(withText(containsString("$8.00"))))
  }
}