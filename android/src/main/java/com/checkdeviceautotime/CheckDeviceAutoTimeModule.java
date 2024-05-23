package com.checkdeviceautotime;

import androidx.annotation.NonNull;


import android.content.Context;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import android.provider.Settings;

@ReactModule(name = CheckDeviceAutoTimeModule.NAME)
public class CheckDeviceAutoTimeModule extends ReactContextBaseJavaModule {
  public static final String NAME = "CheckDeviceAutoTime";
  private final ReactApplicationContext reactContext;

  public CheckDeviceAutoTimeModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void isAutomaticTimeEnabled(Promise promise) {
    try {
      int autoTime = Settings.Global.getInt(reactContext.getContentResolver(), Settings.Global.AUTO_TIME);
      promise.resolve(autoTime == 1);
    } catch (Settings.SettingNotFoundException e) {
      promise.reject("SettingsError", "Could not retrieve automatic time setting.");
    }
  }
}
