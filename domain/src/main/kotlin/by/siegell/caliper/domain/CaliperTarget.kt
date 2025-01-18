package by.siegell.caliper.domain

/**
 * Указывает для Caliper необходимость анализировать класс
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class CaliperTarget
