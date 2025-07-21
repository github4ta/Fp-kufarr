package by.kufar.utils;

import com.github.javafaker.Faker;

public class DataGenerator {
    private static final ThreadLocal<Faker> faker = ThreadLocal.withInitial(Faker::new);

    public static String randomEmail() {
        return faker.get().internet().emailAddress();
    }

    public static String randomPassword() {
        return faker.get().internet().password(8, 16);
    }
}