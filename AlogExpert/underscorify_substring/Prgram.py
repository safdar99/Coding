def underscorifySubstring(string, substring):
    # Write your code here.
	indexPairs = doKMP(string, substring)
	print(indexPairs)
	ans = []
	i = 0
	j = 0
	while i < len(string):
		if j == len(indexPairs):
			ans.append(string[i])
			i += 1
			continue
		curPair = indexPairs[j]
		j += 1
		while i < curPair[0]:
			ans.append(string[i])
			i += 1
		ans.append("_")
		while i <= curPair[1]:
			ans.append(string[i])
			i += 1
		ans.append("_")
	return ''.join(ans)

def getLPS(pat):
	lps = [-1 for _ in pat]
	j = 0
	i = 1
	while i < len(pat):
		if pat[j] == pat[i]:
			lps[i] = j
			i += 1
			j += 1
		elif j > 0:
			j = lps[j-1]+1
		else:
			i += 1
	return lps

def doKMP(string, pat):
	lps = getLPS(pat)
	j = 0
	i = 0
	indexPairs = []
	prevPair = None
	while i < len(string):
		if string[i] == pat[j]:
			i += 1
			j += 1
		elif j > 0:
			j = lps[j-1]+1
		else:
			i += 1
		if j == len(pat):
			start = i-j
			end = start+len(pat)-1
			curPair = [start, end]
			if prevPair != None and prevPair[1]+1 >= start:
				prevPair[1] = end
			else:
				indexPairs.append(curPair)
				prevPair = curPair
			j = lps[j-1] + 1
	return indexPairs