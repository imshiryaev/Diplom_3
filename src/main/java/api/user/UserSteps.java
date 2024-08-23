package api.user;

import api.config.BaseHttpClient;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;


import static io.restassured.RestAssured.given;

public class UserSteps {
    private static final String CREATE_USER = "/api/auth/register";
    private static final String LOGIN = "/api/auth/login";
    private static final String USER_ENDPOINT = "/api/auth/user";

    @Step("Создание нового пользователя")
    public ValidatableResponse createUser(User user) {
        return given(BaseHttpClient.baseRequestSpec())
                .body(user)
                .when()
                .post(CREATE_USER).then();
    }

    @Step("Логин пользователя")
    public ValidatableResponse loginUser(User user) {
        return given(BaseHttpClient.baseRequestSpec())
                .body(user)
                .when()
                .post(LOGIN)
                .then();
    }

    @Step("Удаление пользователя")
    public void deleteUser(String accessToken) {
        given(BaseHttpClient.baseRequestSpec())
                .header("Authorization", accessToken)
                .when()
                .delete(USER_ENDPOINT)
                .then();
    }
}