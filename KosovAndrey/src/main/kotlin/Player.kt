import java.lang.Exception
import kotlin.math.abs

class Player : Creature() {
    var healing: Int = 3
    fun createPlayer(player: Player) {
        do {
            print("Введите параметры атаки: ")
            try {
                val attack = readln().toInt()
                if (attack in ATTACK_MIN..ATTACK_MAX) {
                    player.attack = attack
                } else {
                    println("\nОшибка! Допустимые значения для атаки от 1 до 20!\n")
                }
            } catch (e: Exception) {
                println("\nОшибка! Допустимые значения для атаки от 1 до 20!\n")
            }
        } while (player.attack !in ATTACK_MIN..ATTACK_MAX)
        do {
            print("Введите параметр защиты: ")
            try {
                val defense = readln().toInt()
                if (defense in DEFENSE_MIN..DEFENSE_MAX) {
                    player.defense = defense
                } else {
                    println("\nОшибка! Допустимые значения для защиты от 1 до 20!\n")
                }
            } catch (e: Exception) {
                println("\nОшибка! Допустимые значения для защиты от 1 до 20!\n")
            }
        } while (player.defense !in DEFENSE_MIN..DEFENSE_MAX)
        do {
            print("Введите параметр здоровья: ")
            try {
                val health = readln().toInt()
                if (health > HEALTH_MIN) {
                    player.health = health
                    player.maxHealth = player.health
                } else {
                    println("\nОшибка! Введите натуральное число!\n")
                }
            } catch (e: Exception) {
                println("\nОшибка! Введите натуральное число!\n")
            }
        } while (player.health < HEALTH_MIN)
        do {
            print("Введите параметр минимального урона: ")
            try {
                val minDamage = abs(readln().toInt())
                player.minDamage = minDamage
            } catch (e: Exception) {
                println("\nОшибка! Введите целое число!\n")
            }
        } while (player.minDamage <= Int.MIN_VALUE )
        do {
            print("Введите параметр максимального урона: ")
            try {
                val maxDamage = abs(readln().toInt())
                if (maxDamage >= player.minDamage) {
                    player.maxDamage = maxDamage
                } else {
                    println("\nОшибка! Параметр максимального урона должен быть больше параметра минимального урона!\n")
                }
            } catch (e: Exception) {
                println("\nОшибка! Введите целое число!\n")
            }
        } while (player.maxDamage <= Int.MIN_VALUE )
        showPlayer(player = player)
    }
    fun heal(player: Player) {
        if (player.health >= player.maxHealth / 2) {
            println("Для того, чтобы использовать исцеление, уровень здоровья должен быть меньше половины.\n")
        } else {
            if (player.healing > 0) {
                player.health = player.maxHealth / 2
                player.healing -= 1
                println("\nВы успешно использовали исцеление.\n")
                player.showPlayer(player)
            } else {
                println("У вас не осталось доступных исцелений")
            }
        }
    }
    fun showPlayer(player: Player) {
        println("\nПараметры игрока")
        println("Атака: ${player.attack}")
        println("Защита: ${player.defense}")
        println("Здоровье: ${player.health}/${player.maxHealth}")
        println("Количество доступных исцелений: ${player.healing}")
        println("Урон: ${player.minDamage}-${player.maxDamage}\n")
    }
}
