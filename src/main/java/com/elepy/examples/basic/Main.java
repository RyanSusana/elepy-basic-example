package com.elepy.examples.basic;

import com.elepy.Elepy;
import com.elepy.admin.ElepyAdminPanel;
import com.github.fakemongo.Fongo;
import com.mongodb.DB;


public class Main {
    public static void main(String[] args) {

        //Embedded MongoDB instance
        Fongo fongo = new Fongo("examples");
        DB exampleDB = fongo.getDB("example1");

        new Elepy()
                //Attach a singleton to Elepy. To use Mongo with Elepy, you need to attach a DB
                .registerDependency(DB.class, exampleDB)

                //Run locally(this is also the default)
                .withIPAdress("localhost")

                //The port Elepy will run on.
                .onPort(7777)

                //Add your first Elepy Annotated Model. You can alternatively add an entire package of models.
                .addModel(Product.class)

                //Add an Elepy extension. The AdminPanel/CMS is a great start :D
                .addExtension(new ElepyAdminPanel())

                //Start Elepy!
                .start();

        // browse to http://localhost:7777/admin
    }
}
