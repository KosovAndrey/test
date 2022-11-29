import java.lang.Exception

fun main() {
    do {
        println("***************************")
        println("Введите параметры игрока\n")
        val player = Player()
        player.createPlayer(player)
        println("\nСоздайте нового монстра!")
        val monster = Monster()
        println("Создать случайного монстра - 1")
        println("Создать монстра вручную - 2")
        var choice: Int = choose(number = 2)
        when (choice) {
            1 -> monster.createRandomMonster(player = player, monster = monster)
            2 -> monster.createMonster(monster = monster)
        }
        while (player.health > 0 && monster.health > 0) {
            println(
                """Выберите действие
                1 - атаковать монстра
                2 - использовать исцеление
                3 - посмотреть свои характеристики
                4 - посмотреть характеристики монстра
                5 - убежать
            """.trimMargin()
            )
            choice = choose(number = 5)
            when (choice) {
                1 -> attack(player = player, monster = monster)
                2 -> player.heal(player)
                3 -> player.showPlayer(player = player)
                4 -> monster.showMonster(monster = monster)
                5 -> {
                    println("Вы убежали от монстра")
                    break
                }
            }
        }
        println(
            """Выберите действие
                1 - начать игру заново
                2 - выйти из игры
            """.trimMargin()
        )
        choice = choose(number = 2)
    } while (choice == 1)
}
fun attack(player: Player, monster: Monster) {
    println("\nИгрок атакует монстра!")
    if (dice(number = calculateAttackModifier(attack = player.attack, defense = monster.defense))) {
        val damage = (player.minDamage..player.maxDamage).random()
        println("Игрок наносит $damage урона!")
        monster.health -= damage
    } else {
        println("Игрок промахнулся!")
    }
    if (monster.health > 0) {
        println("\nМонстр атакует игрока в ответ!")
        if (dice(number = calculateAttackModifier(attack = monster.attack, defense = player.defense))) {
            val damage = (monster.minDamage..monster.maxDamage).random()
            println("Монстр наносит $damage урона!")
            player.health -= damage
        } else {
            println("Монстр промахнулся!")
        }
    }
    when {
        monster.health <= 0 -> {
            println("Монстр был побежден!\n")
            player.showPlayer(player = player)
        }
        player.health <= 0 -> {
            println("Игрок был побежден!")
        }
        else -> {
            player.showPlayer(player = player)
            monster.showMonster(monster = monster)
        }
    }
}
fun dice(number: Int): Boolean {
    var count = 0
    for (i in 1..number) {
        if ((1..6).random() in 5..6) {
            count++
        }
    }
    return count != 0
}
fun calculateAttackModifier(attack: Int, defense: Int): Int{
    val attackModifier = (defense - attack + 1).let {
        if (it > 1) it else 1
    }
    return attackModifier
}
fun choose(number: Int): Int {
    var choice = 0
    do {
        print("Ваш выбор: ")
        try {
            choice = readln().toInt()
            println()
            if (choice !in 1..number) {
                println("Ошибка! Введите число от 1 до $number!")
            }
        } catch (e: Exception) {
            println("Ошибка! Введите число от 1 до $number!")
        }
    } while(choice !in 1..number)
    return choice
}
