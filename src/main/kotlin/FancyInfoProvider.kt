class FancyInfoProvider : BasicInfoProvider() {

    override val sessionIdPrefix: String // protected라도 open이기 때문에 가능!
        get() = "Fancy Session"

    override val providerInfo: String
        get() = "FancyInfo Provider"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Fancy Info")
    }
}