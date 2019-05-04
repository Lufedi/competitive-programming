class Tree:
    def __init__(self, value, end=False):
        self.value = value
        self.nodes  = {}
        self.end = end
    def insert(self, key):
        head = self
        node = None
        for c in key:
            if not c in head.nodes.keys():
                node = Tree(c)
                head.nodes[c] = node
            head = head.nodes[c] 
        head.end = True
    def match(self, word, index):
        head = self.nodes
        lng = 0
        ans = 0
        for i in range(index, len(word)):
            if word[i] in head:
                lng+=1
                if head[word[i]].end:
                    ans =max(ans, lng)
                head = head[word[i]].nodes
            else:
                break
        return ans

def findSubstrings(w, p):
    pt = buildTree(p)
    rw = []
    for word in w:
        res = (0,0)
        for i in range(len(word)):
            temp = pt.match(word, i)
            if temp > res[0]:
                res = (temp,i)
            elif temp==res[0]:
                if i < res[1]:
                    res = (temp,i)
            else:
                pass
        l,i = res
        if l > 0:
            rw.append(word[:i]+"["+word[i:i+l]+"]"+word[i+l:])
        else:
            rw.append(word)
    return rw

def buildTree(p):
    t = Tree('@')
    for w in p:
        t.insert(w)
    return t
            
            

words= ["neuroses", "myopic", "sufficient", "televise", "coccidiosis", "gules", "during", "construe", "establish", "ethyl"]
parts= ["aaaaa", "Aaaa", "E", "z", "Zzzzz", "a", "mel", "lon", "el", "An", "ise", "d", "g", "wnoVV", "i", "IUMc", "P", "KQ", "QfRz", "Xyj", "yiHS"]
print(findSubstrings(words,parts))
