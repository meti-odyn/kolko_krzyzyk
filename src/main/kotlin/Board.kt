open class Board (val size: Int = 3)
{
    private val fieldValues: Array<CharArray> = Array(size) { CharArray(size) { ' ' } }
    
    fun setField (row: Int, col: Int, value: Char) : Boolean {
        if (fieldValues [row][col] ==' ') {
            fieldValues [row][col] = value
            return true
        }
        return false
    }

    fun checkIfWin (): Boolean {
        var axisIsWin1 = fieldValues[0][0] != ' '
        var axisIsWin2 = fieldValues[size-1][size-1]!= ' '
        for (i in 1..<size) {
            if( axisIsWin1 && fieldValues [i][i] != fieldValues[i-1][i-1])
            {
                axisIsWin1= false
            }
            if( axisIsWin2 && fieldValues [i][size-i -1]!= fieldValues[i-1][size-i -2])
            {
                axisIsWin2= false
            }
            if(!axisIsWin1 &&!axisIsWin2) break
        }
        if (axisIsWin1 || axisIsWin2) {
            return true
        }

        for (row in 0..<size) {
            var rowIsWin = true
            var colIsWin = true
            if(fieldValues[row][row]==' ')
                continue

            for (col in 1 ..< size) {
                if (fieldValues[row][col] != fieldValues[row][col - 1]) {
                    rowIsWin = false
                    break
                }
            }
            if (rowIsWin) {
                return true
            }

            val col = row
            for (row2 in 1..< size) {
                if (fieldValues[row2][col]!=fieldValues[row2-1][col]) {
                    colIsWin = false
                    break
                }
            }
            if (colIsWin) {
                return true
            }
        }
        return false
    }


    fun atLeastOneFieldEmpty() : Boolean {
        for(row in fieldValues.indices) { //iteruje po indeksach
            for(element in fieldValues[row]) { //iteruje po elementch, ich wartosciach
                if(element ==' ') {
                    return true
                }
            }
        }
        return false
    }

    override fun toString(): String {
        var boardString: String = ""
        var colString: String = "  "
        repeat(size) {
            boardString += (it+1).toString() + " "
            boardString += fieldValues[it].joinToString(" | ")
            boardString += " \n"
            colString += " " + (it+1) + "  "
        }
        boardString = colString + "\n" + boardString
        return boardString
    }
}