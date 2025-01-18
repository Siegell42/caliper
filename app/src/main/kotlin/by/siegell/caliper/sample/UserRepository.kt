package by.siegell.caliper.sample

/**
 * Ещё одна сущность, с которой работаем отдельно от основной Entity.
 */
data class UserEntity(
    val userId: Int,
    val userName: String
)

/**
 * Репозиторий для работы с UserEntity.
 * Аналогично, хранит данные в памяти.
 */
class UserRepository {

    private val userDb = mutableMapOf<Int, UserEntity>()

    init {
        userDb[1] = UserEntity(1, "Alice")
        userDb[2] = UserEntity(2, "Bob")
    }

    fun getUserById(id: Int): UserEntity? {
        return userDb[id]
    }

    fun updateUser(user: UserEntity) {
        userDb[user.userId] = user
    }
}