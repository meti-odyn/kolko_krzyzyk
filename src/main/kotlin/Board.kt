open class Board (val size: Int = 3) {

    private var emptyFieldCount = size * size
    private val fieldValues: Array<CharArray> = Array(size) { CharArray(size) { ' ' } }

    fun coordinateValidation (row: Int, col: Int) : Boolean = row in 0..<size && col in 0..<size
    
    fun setField (row: Int, col: Int, value: Char) : Boolean {
        if (coordinateValidation(row,col) && fieldValues [row][col] ==' ') {
            fieldValues [row][col] = value
            emptyFieldCount--
            return true
        }
        return false
    }

    fun checkIfWin (): Boolean {
        if(evaluateDiagonalsIsWin()) {
            return true
        }
        for (rowOrCol in 0..<size) {
            if(fieldValues[rowOrCol][rowOrCol]==' '){
                continue
            }
            if (evaluateRowIsWin(rowOrCol) || evaluateColIsWin(rowOrCol)) {
                return true
            }
        }
        return false
    }

    fun atLeastOneFieldEmpty() : Boolean = this.emptyFieldCount > 0

    override fun toString(): String {
        val boardString = buildString {
            append(" ")
            repeat(size) {
                append(" ")
                append(it+1)
                append(" ")
            }
            append(" \n")
            repeat(size) {
                append(it+1)
                append(" ")
                append(fieldValues[it].joinToString(" | "))
                append(" \n")
            }
        }
        return boardString.toString()
    }

    private fun evaluateDiagonalsIsWin() : Boolean {
        var axisIsWin1 = fieldValues[0][0] != ' '
        var axisIsWin2 = fieldValues[0][size-1] != ' '

        for (i in 1..<size) {
            if(!axisIsWin1 &&!axisIsWin2) {
                return false
            }

            if( axisIsWin1 && fieldValues [i][i] != fieldValues[i-1][i-1])
            {
                axisIsWin1= false
            }
            if( axisIsWin2 && fieldValues [i][size-i -1] != fieldValues[i-1][size-i])
            {
                axisIsWin2= false
            }
        }
        return axisIsWin1 || axisIsWin2
    }

    private fun evaluateRowIsWin(row: Int) : Boolean {

        for (col in 1 ..< size) {
            if (fieldValues[row][col] != fieldValues[row][col - 1]) {
                return false
            }
        }
        return true
    }

    private fun evaluateColIsWin (col: Int) : Boolean {

        for (row in 1..< size) {
            if (fieldValues[row][col] != fieldValues[row-1][col]) {
                return false
            }
        }
        return true
    }
}