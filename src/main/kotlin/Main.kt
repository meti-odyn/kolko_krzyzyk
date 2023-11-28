fun PlayKolkoKrzyzyk (player1: String? = null, player2: String? = null, boardSize: Int? = null) {
    val play = when {
        player1 != null && player2 != null && boardSize != null -> Game(player1, player2, boardSize)
        player1 != null && player2 != null ->Game(player1, player2)
        player1 != null && boardSize != null -> Game(player1, sizeOfBoard = boardSize)
        player1 != null -> Game(player1)
        player2 != null && boardSize != null -> Game(player2 = player2, sizeOfBoard = boardSize)
        player2 != null -> Game(player2 = player2)
        boardSize != null -> Game(boardSize)
        else -> Game()
    }
    play.run()
}

fun main(args: Array<String>) {
    PlayKolkoKrzyzyk()
}