def longestString(A: int, B: int, C: int) -> str:
    # WRITE YOUR BRILLIANT CODE HERE
    chars = [
        ['a', A],
        ['b', B],
        ['c', C]
    ]
    totalC = A + B + C
    s = []
    while (len(s) < totalC):
        chars.sort(key = lambda x: x[1], reverse=True)
        print(s, chars)
        idx = 0
        if len(s) >= 2 and s[len(s)-1] == chars[0][0] and s[len(s)-2] == chars[0][0]:
            idx = 1
        if chars[idx][1] == 0:
            break
        s.append(chars[idx][0])
        chars[idx][1] -= 1
    return ''.join(s)
        
        
        
        
        
        
        
        
        
        
    
if __name__ == "__main__":
    A = int(input())
    B = int(input())
    C = int(input())
    print(longestString(A, B, C))

