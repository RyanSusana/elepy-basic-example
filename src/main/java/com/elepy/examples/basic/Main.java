package com.elepy.examples.basic;

import com.elepy.Elepy;
import com.elepy.admin.ElepyAdminPanel;
import com.elepy.mongo.MongoConfiguration;

public class Main {
    public static void main(String[] args) {
        new Elepy()
                .onPort(8080)
                .addModel(Product.class)
                .addExtension(new ElepyAdminPanel())
                .addConfiguration(MongoConfiguration.inMemory())
                .start();

    }
}
