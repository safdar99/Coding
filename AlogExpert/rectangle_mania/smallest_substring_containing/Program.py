def smallestSubstringContaining(bigString, smallString):
    # Write your code here.
	charMap = {}
	for c in smallString:
		if charMap.get(c) == None:
			charMap[c] = 1
		else:
			charMap[c] += 1
	minLen = len(bigString)+1
	minSubstring = ""
	l = 0
	r = 0
	remaining = len(smallString)
	while r < len(bigString):
		while remaining == 0 and l <= r:
			curSubstring = bigString[l: r+1]
			if minLen > len(curSubstring): 
				minSubstring = curSubstring
				minLen = len(minSubstring)
			c = bigString[l]
			l += 1
			if charMap.get(c) != None:
				charMap[c] += 1
				if charMap[c] > 0:
					remaining += 1
			if remaining != 0:
				r += 1
		while remaining != 0 and r < len(bigString):
			c = bigString[r]
			if charMap.get(c) != None:
				charMap[c] -= 1
				if charMap[c] >= 0:
					remaining -= 1
			if remaining != 0:
				r += 1
	return minSubstring
