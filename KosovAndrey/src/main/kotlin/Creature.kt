abstract class Creature {
    companion object {
        const val ATTACK_MIN = 1
        const val ATTACK_MAX = 20
        const val DEFENSE_MIN = 1
        const val DEFENSE_MAX = 20
        const val HEALTH_MIN = 0
    }
    var attack: Int = Int.MIN_VALUE
    var defense: Int = Int.MIN_VALUE
    var health: Int = Int.MIN_VALUE
    var maxHealth: Int = Int.MIN_VALUE
    var minDamage: Int = Int.MIN_VALUE
    var maxDamage: Int = Int.MIN_VALUE

}
