package utils

import boxes.LargeSizeBox
import boxes.MiddleSizeBox
import boxes.SizeBox
import boxes.SmallSizeBox
import data.User

class BoxGenerator {
    fun generate(users: List<User>): List<SizeBox> {
        return users.map { user ->
            return@map when (user.message.count()) {
                in 0..50 -> LargeSizeBox(user)
                in 51..100 -> MiddleSizeBox(user)
                else -> SmallSizeBox(user)
            }
        }
    }
}
