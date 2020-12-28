package utils

import com.github.javafaker.Faker
import data.User

class UserGenerator {
    private val faker = Faker()

    fun generate(amount: Int = 10): List<User> {
        return (1..amount).shuffled().map { i ->
            User(
                id = i,
                name = faker.harryPotter().character(),
                message = faker.harryPotter().quote(),
                profile = (1..25).random()
            )
        }
    }
}
