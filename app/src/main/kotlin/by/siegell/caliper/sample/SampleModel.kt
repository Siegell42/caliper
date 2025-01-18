package by.siegell.caliper.sample

import by.siegell.caliper.domain.CaliperTarget
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Класс, который помечен аннотацией @CaliperTarget для анализа.
 * Показывает "старый" код, частично криво переведённый в Kotlin/Flow.
 */
@CaliperTarget
class SampleModel(
    private val anotherModel: AnotherModel,
    private val networkRepository: NetworkRepository,
    private val entityRepository: EntityRepository,
    private val userRepository: UserRepository
) {

    // Поле, оставшееся от Java-кода (nullable и модифицируется из разных мест)
    private var lastQuery: String? = null

    // Публичное поле, влияющее на состояние объекта
    var isInitialized: Boolean = false

    /**
     * Публичный метод, загружающий данные по строковому запросу.
     * Вызывает приватный метод для допобработки.
     */
    fun loadData(query: String): Flow<Result<String>> {
        lastQuery = query
        isInitialized = true

        return flow {
            emit(Result.success("Starting network request with query=$query"))

            val response = networkRepository.fetchData(query)
            if (response.isNullOrEmpty()) {
                emit(Result.failure<String>(Throwable("Empty or null response from network")))
            } else {
                emit(Result.success(response))
            }

            val processed = processDataInternally(response ?: "no_data")
            emit(Result.success(processed))
        }
    }

    /**
     * Публичный метод, который ре-использует lastQuery, если оно есть.
     */
    fun refreshData(): Flow<Result<String>> {
        val savedQuery = lastQuery ?: "default_query"
        return loadData(savedQuery)
    }

    /**
     * Публичный метод, демонстрирующий одновременную работу с Entity и User.
     * Вызывает сетевой запрос для User и сверяет с локальными данными.
     */
    fun doComplexOperationOnEntities(): Flow<Boolean> {
        return flow {
            val userId = 2
            val userData = networkRepository.fetchUserData(userId)
            val localUser = userRepository.getUserById(userId)

            if (userData == null || localUser == null) {
                emit(false)
            } else {
                // «Обновляем» пользователя
                userRepository.updateUser(localUser.copy(userName = "Updated ${localUser.userName}"))
                // Параллельно трогаем Entity
                val entity = entityRepository.getEntityById(42)
                if (entity != null) {
                    entityRepository.updateEntity(entity.copy(name = "Updated Entity"))
                    emit(true)
                } else {
                    emit(false)
                }
            }
        }
    }

    /**
     * Новый метод, демонстрирующий обращение к AnotherModel и цепочку вызовов.
     * Имитируем «сложную» логику из старого кода.
     */
    fun runAnotherModelProcess(input: String): Flow<Result<String>> {
        return flow {
            // Допустим, вызываем публичный метод AnotherModel, который возвращает Flow
            anotherModel.processData(input).collect { processedData ->
                // Затем мы ещё делаем какую-то дополнительную внутреннюю логику
                val finalData = "$processedData -- final addition"
                emit(Result.success(finalData))
            }
        }
    }

    /**
     * Приватный метод для внутренней переработки данных.
     * Ставит слова задом наперёд, просто для примера.
     */
    private fun processDataInternally(data: String): String {
        val parts = data.split(" ")
        return parts.asReversed().joinToString(" ")
    }

    /**
     * Ещё один приватный метод, который мог бы вызываться в каком-то сложном флоу.
     * Имитация «важной логики» над Entity.
     */
    private fun doInternalWorkOnEntity(entityId: Int): String {
        val entity = entityRepository.getEntityById(entityId)
            ?: return "No entity found for id=$entityId"
        return "doInternalWorkOnEntity: ${entity.name}"
    }
}