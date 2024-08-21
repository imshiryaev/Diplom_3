package api.user;

import net.datafaker.Faker;

public class UserGenerate {
    public static User generateUserData() {

        Faker faker = new Faker();
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        return new User(email, password, name);
    }
}
