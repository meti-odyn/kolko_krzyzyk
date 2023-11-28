class Game (private var player1: String = "Player 1", private var player2: String = "Player 2",
            sizeOfBoard: Int = 3) {

    private val board = Board(sizeOfBoard)

    constructor(boardSize: Int) : this(sizeOfBoard = boardSize)

    fun run() {
        while (round(player1,'x') && round(player2, 'o')) {}
    }

    private fun turn(player: String, value: Char) : Boolean {
        println("-".repeat(20))
        println("$player's turn")
        println("player's symbol: $value")
        var row: Int
        var col: Int
        do {
            println(board)
            println("write row number and press Enter: ")
            row = readln().toInt()
            println("write column number and press Enter: ")
            col = readln().toInt()
        } while(!board.setField(row - 1, col - 1, value))

        println()

        if(board.checkIfWin())
        {
            println("$player won!")
            return true
        }
        return false
    }

    private fun round(player: String, value: Char) : Boolean {

        if(turn(player, value)) {
            return false
        }
        if(!board.atLeastOneFieldEmpty()) {
            println("Draw!")
            return false
        }
        println(board)
        return true
    }
}