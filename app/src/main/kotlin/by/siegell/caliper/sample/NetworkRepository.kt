package by.siegell.caliper.sample

/**
 * Репозиторий для имитации сетевых запросов.
 * Содержит два метода fetch*Data для демонстрации разных запросов.
 */
class NetworkRepository {

    /**
     * Имитируем основной fetch-метод, возвращающий данные по некоему query.
     * Может вернуть null, что усложняет логику обработки.
     */
    fun fetchData(query: String): String? {
        return if (query.isNotBlank()) {
            "Response from network for query: $query"
        } else {
            null
        }
    }

    /**
     * Второй метод, имитирующий получение данных пользователя по ID.
     */
    fun fetchUserData(userId: Int): String? {
        return if (userId > 0) {
            "User data for ID=$userId"
        } else {
            null
        }
    }
}