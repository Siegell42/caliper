package by.siegell.caliper.sample

/**
 * Пример сущности (Entity), с которой мы работаем в EntityRepository.
 */
data class Entity(
    val id: Int,
    val name: String
)

/**
 * Репозиторий для работы с Entity.
 * Хранит данные в in-memory-словаре, имитируя простую БД.
 */
class EntityRepository {

    private val inMemoryDb = mutableMapOf<Int, Entity>()

    init {
        // Тестовые данные
        inMemoryDb[42] = Entity(42, "Test Entity")
    }

    fun getEntityById(id: Int): Entity? {
        return inMemoryDb[id]
    }

    fun updateEntity(entity: Entity) {
        inMemoryDb[entity.id] = entity
    }
}