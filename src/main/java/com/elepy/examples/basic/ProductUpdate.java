package com.elepy.examples.basic;

import com.elepy.Elepy;
import com.elepy.dao.Crud;
import com.elepy.routes.SimpleUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductUpdate extends SimpleUpdate<Product> {

    private static final Logger logger = LoggerFactory.getLogger(ProductUpdate.class);

    public void beforeUpdate(Product objectToUpdate, Crud<Product> crud, Elepy elepy) {
        logger.info("Product is being updated.");

        // execute extra logic code like sending an e-mail to the boss :D

        // throw an exception(preferably ElepyErrorMessage) to block the update
    }

    public void afterUpdate(Product beforeVersion, Product updatedVersion, Crud<Product> crud, Elepy elepy) {

        logger.info("Product has been updated.");
    }
}
