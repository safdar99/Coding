t = int(input())

while t != 0:
    t -= 1
    D, d, P, Q = map(int, input().split(' '))

    n = int(D/d)
    sum = d*((n/2)*(2*P + (n-1)*Q))
    print(sum)
    lastTerm = P + (n)*Q
    remainingDays = D % d
    sum += lastTerm*remainingDays
    print(int(sum))
