package com.example.shoppingappfrontend.network;

import com.example.shoppingappfrontend.AppScaffold;
// PUBLIC_INTERFACE
/**
 * ApiClient provides helper methods for API requests by referencing .env for base URL.
 * Each feature module (auth, products, cart, orders) will use this client for network operations.
 */
public class ApiClient {
    public static String getBaseUrl() {
        // This references environment (BuildConfig) variable injected from .env
        return AppScaffold.getApiBaseUrl();
    }
    // TODO: Add OkHttp/Retrofit or fetch calls for user/auth/products/carts/orders/etc
}
