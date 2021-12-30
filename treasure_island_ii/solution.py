from typing import List

def routeStep(matrix: List[List[str]]) -> int:
    # WRITE YOUR BRILLIANT CODE HERE
    rows = len(matrix)
    cols = len(matrix[0])
    starts = []
    for row in range(rows):
        for col in range(cols):
            if matrix[row][col] == 'S':
                starts.append([row, col, 0])
                matrix[row][col] = ' '
    return bfs(matrix, starts)
    
    
def bfs(mat, starts):
    from collections import deque
    q = deque(starts)
    ans = 0
    while len(q) != 0:
        r, c, lvl = q.popleft()
        # print(r, c, lvl)
        childs = getChildsOf(r, c, mat)
        for x, y in childs:
            if mat[x][y] == 'X':
                ans = lvl+1
                return ans
            if mat[x][y] != 'D' and mat[x][y] != ' ':
                q.append([x, y, lvl+1])
                mat[x][y] = ' '
    return ans

def getChildsOf(r, c, mat):
    childs = []
    if r > 0:
        childs.append([r-1, c])
    if c < len(mat[0])-1:
        childs.append([r, c+1])
    if r < len(mat)-1:
        childs.append([r+1, c])
    if c > 0:
        childs.append([r, c-1])
    return childs

if __name__ == "__main__":
    rows = int(input())
    matrix = [[x for x in input().split()] for _ in range(rows)]
    result = routeStep(matrix)
    print(result)


'''
5
S O O S S
D O D O D
O O O O X
X D D O O 
X D D D O
'''