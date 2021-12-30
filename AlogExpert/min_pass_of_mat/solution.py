
# O(w*h) time | O(w*h) space
from queue import Queue

def getAllChilds(mat, row, col, vis):
	rows = len(mat)
	cols = len(mat[0])
	formats = [
		[-1, 0], [0, 1], [1, 0], [0, -1]
	]
	childs = []
	for x, y in formats:
		cx = row+x
		cy = col+y
		if cx >= 0 and cx < rows and cy >= 0 and cy < cols and not vis[cx][cy]:
			if mat[cx][cy] != 0:
				childs.append([cx, cy, mat[cx][cy]])
	return childs

def minimumPassesOfMatrix(mat):
    # Write your code here.
	q = Queue(0)
	neg = 0
	rows = len(mat)
	cols = len(mat[0])
	vis = [[False for _ in range(cols)] for _ in range(rows)]
	for row in range(rows):
		for col in range(cols):
			if mat[row][col] > 0:
				q.put([row, col, mat[row][col], 0])
				vis[row][col] = True
			if mat[row][col] < 0:
				neg += 1
	while not q.empty():
		row, col, val, lvl = q.get()
		childs = getAllChilds(mat, row, col, vis)
		for cx, cy, val in childs:
			if val < 0:
				neg -= 1
			q.put([cx, cy, abs(val), lvl+1])
			vis[cx][cy] = True
	return -1 if neg != 0 else lvl