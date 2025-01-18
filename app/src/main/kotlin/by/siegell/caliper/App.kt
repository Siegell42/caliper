package by.siegell.caliper

import by.siegell.caliper.sample.*

fun main() {
    val model = SampleModel(
        anotherModel = AnotherModel(),
        networkRepository = NetworkRepository(),
        entityRepository = EntityRepository(),
        userRepository = UserRepository()
    )
    println("Hello from Caliper!")
    println("This is sample model: $model")
}
