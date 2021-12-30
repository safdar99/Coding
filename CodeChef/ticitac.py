def tictac():
    tests = int(input())

    while tests != 0:
        row = 0
        matrix = [[]] * 3
        while row != 3:
            matrix[row] = [ char for char in input()]
            row += 1
        tests -= 1
        print(evaluate(matrix))

def evaluate(mat):
    nX = getCount(mat, "X")
    nY = getCount(mat, "O")
    if nX != nY and nX - nY != 1:
        return 3
    if hasWon(mat, "X") and hasWon(mat, "O"):
        return 3
    if hasWon(mat, "X") and nX != nY + 1:
        return 3
    if hasWon(mat, "X"):
        return 1
    if hasWon(mat, "O") and nY != nX:
        return 3
    if hasWon(mat, "O"):
        return 1
    if not isOver(mat):
        return 2
    return 1

def isOver(mat):
    for row in mat:
        for char in row:
            if char == "_":
                return False
    return True

def hasWon(mat, char):
    if char == mat[0][0] and char == mat[0][1] and char == mat[0][2]:
        return True
    if char == mat[1][0] and char == mat[1][1] and char == mat[1][2]:
        return True
    if char == mat[2][0] and char == mat[2][1] and char == mat[2][2]:
        return True
    if char == mat[0][0] and char == mat[1][0] and char == mat[2][0]:
        return True
    if char == mat[0][1] and char == mat[1][1] and char == mat[2][1]:
        return True
    if char == mat[0][2] and char == mat[1][2] and char == mat[2][2]:
        return True
    if char == mat[0][0] and char == mat[1][1] and char == mat[2][2]:
        return True
    if char == mat[0][2] and char == mat[1][1] and char == mat[2][0]:
        return True
    return False

def getCount(mat, char):
    n = 0
    for row in mat:
        for c in row:
            if c == char:
                n += 1
    return n
tictac()