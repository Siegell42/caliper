package by.siegell.caliper.sample

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Класс другой модельки — обрабатывает данные,
 * может работать с Flow или простыми методами.
 *
 * Допустим, он умеет делать какие-то сложные преобразования или дополнительную логику.
 */
class AnotherModel {

    /**
     * Публичный метод, возвращающий Flow.
     * Имитируем некий асинхронный процесс обработки данных.
     */
    fun processData(data: String): Flow<String> {
        return flow {
            // Допустим, сначала «подготавливаем»
            val prepared = prepareData(data)
            // Затем «основная» обработка
            val processed = mainProcessing(prepared)
            emit(processed)
        }
    }

    /**
     * Публичный метод, который не возвращает Flow, но может содержать цепочку вызовов.
     */
    fun doSomeChainedCalls(number: Int): String {
        val step1 = "Initial number: $number"
        val step2 = applyTransformation(step1)
        val step3 = "Final: $step2"
        return step3
    }

    /**
     * Приватный метод, эмулирующий подготовку данных.
     */
    private fun prepareData(data: String): String {
        return data.trim().uppercase()
    }

    /**
     * Приватный метод, эмулирующий основную обработку.
     */
    private fun mainProcessing(preparedData: String): String {
        // Допустим, делаем реверс и добавляем приписку
        val reversed = preparedData.reversed()
        return "$reversed - PROCESSED"
    }

    /**
     * Приватный метод, ещё одна часть цепочки.
     */
    private fun applyTransformation(input: String): String {
        return "[TRANSFORMED] $input"
    }
}