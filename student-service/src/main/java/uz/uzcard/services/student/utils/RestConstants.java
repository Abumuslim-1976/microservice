package uz.uzcard.services.student.utils;

public interface RestConstants {
    String BASE_PATH = "/api/open-product";
    String DOMAIN = "http://localhost";
    String PRODUCT_CONTROLLER =  BASE_PATH + "/product";
    String RECOMMENDED_PRODUCT_CONTROLLER =  BASE_PATH + "/recommended-product";

    String AUTH_SERVICE = "AUTH-SERVICE/api/open-auth";
    String REQUEST_ATTRIBUTE_CURRENT_USER = "user";
}
