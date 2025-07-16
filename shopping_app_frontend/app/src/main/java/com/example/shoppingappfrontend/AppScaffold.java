package com.example.shoppingappfrontend;

import android.app.Application;

/**
 * Shopease AppScaffold serves as the initialization entry-point for global app objects and utility methods.
 * Enforces .env variable referencing, REST API base URL loading, and dependency providers.
 * All feature modules should reference this as the root app context.
 */
public class AppScaffold extends Application {
    private static AppScaffold instance;
    // Example for referencing environment variables via BuildConfig (runtime-safe)
    public static String getApiBaseUrl() {
        return BuildConfig.API_BASE_URL;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        // Init code for analytics, crash reporting, etc., if needed
    }

    public static AppScaffold getInstance() {
        return instance;
    }
}
