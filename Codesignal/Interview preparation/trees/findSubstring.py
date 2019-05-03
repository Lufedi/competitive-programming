class Tree:
    def __init__(self, value):
        self.value = value
        self.nodes  = {}
    def addn(self, value):
        self.nodes[value] = Tree(value)
    def getn(self, value):
        return self.nodes[value]

def findSubstring(w, p):
    pt = buildTree(p)
    res = (0,0)
    for i in range(len(w)):
        temp = match(w, i, pt)
        if temp > res[0]:
            res = (temp,i)
        elif temp==res[0]:
            if i < res[1]:
                res = (temp,i)
        else:
            pass
            
def match(w, i, t):
    if t.value == 'end':
        return 1
    elif w[i] != t.value:
        return 0
    else:
        res = 0
        for n,p in t.nodes.items():
            res = 1 + max(res,match(w, i+1,t))
        return res
            
            
        
    
        
def buildTree(p):
    t = Tree('@')
    for w in p:
        insertWord(t,p,0)
    return t

def insertWord(t,p,i):
    if i < len(p):
        if not p[i] in t.nodes.keys():
            t.addn(p[i])
        insertWord(t.getn(p[i]), p, i+1)
    else:
        return
            
            
