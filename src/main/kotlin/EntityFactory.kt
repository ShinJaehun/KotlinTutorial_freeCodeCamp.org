import java.util.*

//interface IdProvider {
//    fun getId(): String
//}

//class Entity private constructor(val id: String) {
//    // 일단 그냥 이렇게만 해서는 private 때문에 사용 불가
//
////    companion object {
////        fun create() = Entity("id")
////    }
//
//    companion object Factory : IdProvider {
////        fun create() = Entity("id")
//
//        override fun getId(): String {
//            return "123"
//        }
//        const val id = "id"
//        fun create() = Entity(getId())
//    }
//}
//
//fun main() {
//    val entity = Entity("id") // private 때문에 이렇게 사용 불가
//    val entity = Entity.Companion.create()
//    val entity = Entity.create() // 이렇게 사용 가능
//    val entity = Entity.Factory.create() // 별칭 사용 가능
//    println(entity.id) // 이렇게 접근 가능 -> 123 출력
//    println(Entity.id) // 이것도 사용 가능 -> id 출력
//}

//object EntityFactory {
//    fun create() = Entity("id", "name")
//}
//
//class Entity(val id: String, val name: String) {
//    override fun toString(): String {
//        return "id:$id name:$name"
//    }
//}
//
//fun main() {
//    val entity = EntityFactory.create()
//    println(entity)
//}

//enum class EntityType {
//    EASY, MEDIUM, HARD;
//
//    fun getFormattedName() = name.toLowerCase().capitalize()
//}
//
//object EntityFactory {
//    fun create(type: EntityType) : Entity {
//        val id = UUID.randomUUID().toString()
//        val name = when(type) {
//            EntityType.EASY -> type.name
//            EntityType.MEDIUM -> type.getFormattedName()
//            EntityType.HARD -> "Hard"
//        }
//        return Entity(id, name)
//    }
//}
//
//class Entity(val id: String, val name: String) {
//    override fun toString(): String {
//        return "id:$id name:$name"
//    }
//}
//
//fun main() {
//    val entity = EntityFactory.create(EntityType.EASY)
//    println(entity)
//    val entity2 = EntityFactory.create(EntityType.MEDIUM)
//    println(entity2)
//}

//enum class EntityType {
//    HELP, EASY, MEDIUM, HARD;
//
//    fun getFormattedName() = name.toLowerCase().capitalize()
//}
//
//object EntityFactory {
//    fun create(type: EntityType) : Entity {
//        val id = UUID.randomUUID().toString()
//        val name = when(type) {
//            EntityType.HELP -> type.getFormattedName()
//            EntityType.EASY -> type.name
//            EntityType.MEDIUM -> type.getFormattedName()
//            EntityType.HARD -> "Hard"
//        }
//        return when(type) {
//            EntityType.EASY -> Entity.Easy(id, name)
//            EntityType.MEDIUM -> Entity.Medium(id, name)
//            EntityType.HARD -> Entity.Hard(id, name, multiplier = 2f)
//            EntityType.HELP -> Entity.Help
//        }
//    }
//}
//
//sealed class Entity() {
//    object Help : Entity() {
//        val name = "Help"
//    }
//    data class Easy(val id: String, val name: String): Entity()
//    data class Medium(val id: String, val name: String): Entity()
//    data class Hard(val id: String, val name: String, val multiplier: Float): Entity()
//}
//
//fun main() {
//    val entity:Entity = EntityFactory.create(EntityType.EASY)
//    val msg = when(entity) {
//        Entity.Help -> "help class"
//        is Entity.Easy -> "easy class"
//        is Entity.Hard -> "hard class"
//        is Entity.Medium -> "medium class"
//    }
//    println(msg)
//}


//enum class EntityType {
//    HELP, EASY, MEDIUM, HARD;
//
//    fun getFormattedName() = name.toLowerCase().capitalize()
//}
//
//object EntityFactory {
//    fun create(type: EntityType) : Entity {
//        val id = UUID.randomUUID().toString()
//        val name = when(type) {
//            EntityType.HELP -> type.getFormattedName()
//            EntityType.EASY -> type.name
//            EntityType.MEDIUM -> type.getFormattedName()
//            EntityType.HARD -> "Hard"
//        }
//        return when(type) {
//            EntityType.EASY -> Entity.Easy(id, name)
//            EntityType.MEDIUM -> Entity.Medium(id, name)
//            EntityType.HARD -> Entity.Hard(id, name, multiplier = 2f)
//            EntityType.HELP -> Entity.Help
//        }
//    }
//}
//
//sealed class Entity() {
//    object Help : Entity() {
//        val name = "Help"
//    }
//    data class Easy(val id: String, val name: String): Entity()
//    data class Medium(val id: String, val name: String): Entity()
//    data class Hard(val id: String, val name: String, val multiplier: Float): Entity()
//}
//
//fun main() {
////    val entity1 = EntityFactory.create(EntityType.EASY)
////    val entity2 = EntityFactory.create(EntityType.EASY)
////
////    if (entity1 == entity2) { // not equal(random 값인 id 때문에...)
////        println("they are equal")
////    } else {
////        println("they are not equal")
////    }
//
////    val entity1 = Entity.Easy("id", "name")
//////    val entity2 = Entity.Easy("id", "name") // equal
//////    val entity2 = entity1.copy() // equal
////    val entity2 = entity1.copy(name = "new name") // not equal
////
////    if (entity1 == entity2) {
////        println("they are equal")
////    } else {
////        println("they are not equal")
////    }
//
//    val entity1 = Entity.Easy("id", "name")
//    val entity2 = Entity.Easy("id", "name") // ===로는 not equal
//
////    if (entity1 === entity2) {
//    if (entity1 === entity1) { // 당연히 이건 equal
//        println("they are equal")
//    } else {
//        println("they are not equal")
//    }
//}

enum class EntityType {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

object EntityFactory {
    fun create(type: EntityType) : Entity {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            EntityType.HELP -> type.getFormattedName()
            EntityType.EASY -> type.name
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
        }
        return when(type) {
            EntityType.EASY -> Entity.Easy(id, name)
            EntityType.MEDIUM -> Entity.Medium(id, name)
            EntityType.HARD -> Entity.Hard(id, name, multiplier = 2f)
            EntityType.HELP -> Entity.Help
        }
    }
}

sealed class Entity() {
    object Help : Entity() {
        val name = "Help"
    }
    data class Easy(val id: String, val name: String): Entity()
    data class Medium(val id: String, val name: String): Entity()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity()
}

fun Entity.Medium.printInfo() {
    println("Medium class: $id")
}

//val Entity.Medium.info: String = "some info" // 이렇게는 못 쓰고
val Entity.Medium.info: String
    get() = "some info"

fun main() {
    val entity1 = Entity.Easy("id", "name")
    val entity2 = EntityFactory.create(EntityType.MEDIUM)

//    Entity.Medium("id", "name").printInfo()

    if (entity2 is Entity.Medium) {
        entity2.printInfo()
        println(entity2.info)
    }
}