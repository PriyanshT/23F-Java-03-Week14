package com.georgiancollege.week14;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("products")
    private Product[] productsArray;

    public Product[] getProductsArray() {
        return productsArray;
    }
}
