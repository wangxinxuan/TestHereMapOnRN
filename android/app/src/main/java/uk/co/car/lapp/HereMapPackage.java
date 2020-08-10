package uk.co.car.lapp;

import androidx.annotation.NonNull;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.List;

import uk.co.car.lapp.ReactIntentModule;

public class HereMapPackage implements ReactPackage {


    @Override
    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {
        return Arrays.<NativeModule>asList(new ReactIntentModule(reactContext));
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList();
//        return Arrays.<ViewManager>asList(new HereMapManager());
//        List<ViewManager> views = new ArrayList<>();
//        views.add(new HereMapManager());
//        return views;
    }
}



