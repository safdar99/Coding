MOD = 1000000007
class Node:
    def __init__(self, no):
        self.sum = 0
        self.no = no
        self.childs = {}
        self.childList = []

    def addChild(self, child):
        self.childs[child.no] = child
        self.childList.append(child)

def house():
    tests = int(input())

    while tests != 0:
        nodes = {}
        n, x = map(int, input().split())
        for _ in range(n-1):
            u, v = map(int, input().split())
            if nodes.get(u) == None:
                nodes[u] = Node(u)
            if nodes.get(v) == None:
                nodes[v] = Node(v)
            nodes[u].addChild(nodes[v])

        utils(nodes[1])
        print(nodes[1].sum*x % MOD)
        tests -= 1

def utils(node: Node):
    if len(node.childs) == 0:
        node.sum = 1
        return
    for key in node.childs:
        utils(node.childs[key])
    node.childList.sort(key=lambda x: x.sum, reverse=True)
    x = 1
    nodeSum = x
    for child in node.childList:
        child.sum = (child.sum*x) % MOD
        nodeSum = (nodeSum + child.sum) % MOD
        x = (x+1) % MOD
    node.sum = nodeSum

def printTree(node, pad):
    print(pad, node.no)
    for key in node.childs:
        printTree(node.childs[key], pad+"    ")

house()