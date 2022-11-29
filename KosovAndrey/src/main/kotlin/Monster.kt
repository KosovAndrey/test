import java.lang.Exception
import kotlin.math.abs

class Monster : Creature() {
    fun createRandomMonster(player: Player, monster: Monster) {
        monster.attack = (1..(3 * player.attack / 2)).random()
        monster.defense = (1..(3 * player.defense / 2)).random()
        monster.health = (1..(3 * player.health / 2)).random()
        monster.maxHealth = monster.health
        monster.minDamage = (1..(3 * player.minDamage / 2)).random()
        var maxDamage = Int.MIN_VALUE
        while (maxDamage < monster.minDamage) {
            maxDamage = (1..(3 * player.maxDamage / 2)).random()
        }
        monster.maxDamage = maxDamage
        showMonster(monster = monster)
    }
    fun createMonster(monster: Monster) {
        do {
            print("Введите параметры атаки: ")
            try {
                val attack = readln().toInt()
                if(attack in ATTACK_MIN..ATTACK_MAX) {
                    monster.attack = attack
                } else {
                    println("\nОшибка! Допустимые значения для атаки от 1 до 20!\n")
                }
            } catch (e: Exception) {
                println("\nОшибка! Допустимые значения для атаки от 1 до 20!\n")
            }
        } while (monster.attack !in ATTACK_MIN..ATTACK_MAX)
        do {
            print("Введите параметр защиты: ")
            try {
                val defense = readln().toInt()
                if (defense in DEFENSE_MIN..DEFENSE_MAX) {
                    monster.defense = defense
                } else {
                    println("\nОшибка! Допустимые значения для защиты от 1 до 20!\n")
                }
            } catch (e: Exception) {
                println("\nОшибка! Допустимые значения для защиты от 1 до 20!\n")
            }
        } while (monster.defense !in DEFENSE_MIN..DEFENSE_MAX)
        do {
            print("Введите параметр здоровья: ")
            try {
                val health = readln().toInt()
                if (health > HEALTH_MIN) {
                    monster.health = health
                    monster.maxHealth = monster.health
                } else {
                    println("\nОшибка! Введите натуральное число!\n")
                }
            } catch (e: Exception) {
                println("\nОшибка! Введите натуральное число!\n")
            }
        } while (monster.health < HEALTH_MIN)
        do {
            print("Введите параметр минимального урона: ")
            try {
                val minDamage = abs(readln().toInt())
                monster.minDamage = minDamage
            } catch (e: Exception) {
                println("\nОшибка! Введите целое число!\n")
            }
        } while (monster.minDamage <= Int.MIN_VALUE )
        do {
            print("Введите параметр максимального урона: ")
            try {
                val maxDamage = abs(readln().toInt())
                if (maxDamage >= monster.minDamage) {
                    monster.maxDamage = maxDamage
                } else {
                    println("\nОшибка! Параметр максимального урона должен быть больше параметра минимального урона!\n")
                }
            } catch (e: Exception) {
                println("\nОшибка! Введите целое число!\n")
            }
        } while (monster.maxDamage <= Int.MIN_VALUE )
        showMonster(monster = monster)
    }
    fun showMonster(monster: Monster) {
        println("Параметры монстра")
        println("Атака: ${monster.attack}")
        println("Защита: ${monster.defense}")
        println("Здоровье: ${monster.health}/${monster.maxHealth}")
        println("Урон: ${monster.minDamage}-${monster.maxDamage}\n")
    }
}