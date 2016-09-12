package com.playphone.android.alex.automationtest;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by alex on 12/18/15.
 */
@RunWith(AndroidJUnit4.class)
public class SampleTestCase {
	@Test
	public void uiautomatorRun() throws InterruptedException, UiObjectNotFoundException {
		UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
		mDevice.pressHome();

		//Lazy programming:
		Thread.sleep(2000);

		Context context = InstrumentationRegistry.getContext();
		Intent i = context.getPackageManager().getLaunchIntentForPackage("de.schildbach.wallet");
		context.startActivity(i);

		//Lazy programming:
		Thread.sleep(10000);

		UiObject button = mDevice.findObject(new UiSelector().text("Request coins"));
		button.click();
		for (int counter = 0; counter < 1000; counter++) {
			//Lazy programming:
			Thread.sleep(2000);
		}
	}

	private void run() throws InterruptedException {
		ViewInteraction vi = Espresso.onView(ViewMatchers.withText("Hello"));
		for (int i = 0; i < 100; i++) {
			vi.perform(ViewActions.click());
			Thread.sleep(1000);
		}
	}
}
