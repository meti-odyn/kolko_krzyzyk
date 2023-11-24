fun kolkoKrzyzyk (player1: String? = null, player2: String? = null) {
    val play = when {
        player1 != null && player2 != null -> Game(player1, player2)
        player1 != null -> Game(player1)
        player2 != null -> Game(player2 = player2)
        else -> Game()
    }
    play.run()
}

fun main(args: Array<String>) {
    kolkoKrzyzyk()
}