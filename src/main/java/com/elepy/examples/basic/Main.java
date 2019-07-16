package com.elepy.examples.basic;

import com.elepy.Elepy;
import com.elepy.admin.AdminPanel;
import com.elepy.mongo.MongoConfiguration;

public class Main {
    public static void main(String[] args) {
        new Elepy()
                // Choose the port
                .onPort(8080)

                // Add the AdminPanel configuration
                .addConfiguration(AdminPanel.newAdminPanel())

                // Add the Mongo configuration
                .addConfiguration(MongoConfiguration.inMemory())

                // Add your model
                .addModel(Product.class)

                // Begin your journey! :D
                .start();

    }
}
