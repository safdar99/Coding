# cook your dish here

t = int(input())

while t != 0:
    t -= 1
    xa, xb, Xa, Xb = map(int, input().split(' '))
    ca = Xa/xa
    cb = Xb/xb
    print(int(ca+cb))