package com.jiomoney.snapbizz;


import android.graphics.Typeface;
import android.support.multidex.MultiDexApplication;

public class App extends MultiDexApplication {
    private static App sInstance;
    public static Typeface helveticaBold;
    public static Typeface helveticaLight;
    public static Typeface helveticaRegular;
    public static Typeface helveticaMedium;
    public static Typeface rupeeForadian;
    public App() {
        super();
        sInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        helveticaBold = Typeface.createFromAsset(this.getAssets(), "fonts/helvetica_neue_bold.ttf");
        helveticaLight = Typeface.createFromAsset(this.getAssets(), "fonts/helvetica_neue_light.ttf");
        helveticaRegular = Typeface.createFromAsset(this.getAssets(), "fonts/helvetica_neue_regular.ttf");
        helveticaMedium = Typeface.createFromAsset(this.getAssets(), "fonts/helvetica_neue_medium.ttf");
        rupeeForadian = Typeface.createFromAsset(this.getAssets(), "fonts/rupee_foradian.ttf");

    }

    public static App getInstance() {
        return sInstance;
    }

}
