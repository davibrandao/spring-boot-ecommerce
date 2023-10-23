package com.davibrandao.ecommerce.config;

import com.davibrandao.ecommerce.entity.Product;
import com.davibrandao.ecommerce.entity.ProductCategory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry corsRegistry) {
        // disable HTTP Methods for Product: PUT, DELETE, POST
        HttpMethod[] theUnsupportedMethods = {HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.POST};

        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods)));

        // disable HTTP Methods for ProductCategory: PUT, DELETE, POST
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods)));
    }

}
