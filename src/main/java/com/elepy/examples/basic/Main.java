package com.elepy.examples.basic;

import com.elepy.Elepy;
import com.elepy.admin.ElepyAdminPanel;
import com.github.fakemongo.Fongo;
import com.mongodb.DB;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class Main {
    public static void main(String[] args) {
        Logger.getRootLogger().setLevel(Level.INFO);
        org.apache.log4j.BasicConfigurator.configure();

        //Embedded MongoDB instance
        Fongo fongo = new Fongo("examples");
        DB exampleDB = fongo.getDB("example1");

        new Elepy()
                //Attach a singleton to Elepy. To use Mongo with elepy, you need to attach a DB
                .attachSingleton(DB.class, exampleDB)

                //The port Elepy will run on.
                .onPort(7777)

                //Add your first Elepy Annotated Model. You can alternatively add an entire package of models.
                .addModel(Product.class)

                //Add an Elepy extension. The AdminPanel is a great start :D
                .addExtension(new ElepyAdminPanel())

                //Start Elepy!
                .start();
    }
}
