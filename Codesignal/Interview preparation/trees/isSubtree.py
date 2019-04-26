
def isSubtree(a,b):
    c = {}
    gi = 0
    q = [(a,b,0)] if a else []
    if not b: return True

    totalLeafs = 0
    hb = 0
    q = [(b,0)] if b else []
    while q:
        t = q.pop()
        node = t[0]
        hb = max(hb, t[1])
        if not node.left and not node.right:
            totalLeafs+=1
        if node.left:
            q.append((node.left , t[1] + 1))
        if node.right:
            q.append((node.right, t[1] + 1))
    ha = 0
    q = [(a,0)] if a else []
    while q:
        t = q.pop()
        node = t[0]
        ha = max(ha, t[1])
        if not node.left and not node.right:
            totalLeafs+=1
        if node.left:
            q.append((node.left , t[1] + 1))
        if node.right:
            q.append((node.right, t[1] + 1))

    
    
    q = [(a,b,0,0)] if a else []
    while q:
        t = q.pop()
        node = t[0]
        subb= t[1]
        i = t[2]
        h = t[3]
        if ha - h >= hb:
            if node.value == subb.value:
                if subb.left == None and subb.right == None:
                    if not i in c:
                        c[i]=0
                    c[i]+=1
                if subb.left and node.left:
                    gi+= 1
                    q.append((node.left, subb.left, gi, h+1))
                if subb.right and node.right:
                    gi += 1
                    q.append((node.right, subb.right, gi, h+1))               


    for k in c.keys():
        if c[k] == totalLeafs:
            return True
    return False

