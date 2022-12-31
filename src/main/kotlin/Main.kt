class Person(val firstName: String = "Peter", val lastName: String = "Parker") {
    var nickName: String? = null
        set(value){
            field = value
            println("the new nickname is $value")
        }
        get(){
            println("the returned value is $field")
            return field
        }
    fun printInfo() {
        val nickNameToPrint = nickName ?: "no nickname"
        println("$firstName ($nickNameToPrint) $lastName")
    }
}

interface PersonInfoProvider {
    val providerInfo : String // interface이기 때문에 값을 저장할 수는 없음!
    fun printInfo(person: Person) {
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider {
    fun getSessionId(): String
}

open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "BasicInfoProvider"	// 이런 형태로 interface에 값을 지정해줄 수 있음!

//    open val sessionIdPrefix = "Session"
    protected open val sessionIdPrefix = "Session"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
}


fun main(args: Array<String>) {
//    val provider = BasicInfoProvider()
//    val provider = FancyInfoProvider()
//    println(provider.sessionIdPrefix) // protected가 되면 직접 접근 불가(API를 이런 식으로 구현함)

    val provider = object : PersonInfoProvider { // object를 이용해서
        override val providerInfo: String
            get() = "New Info Provider"

        fun getSessionId() = "New Session"
   }

    provider.printInfo(Person())
    provider.getSessionId()
}
