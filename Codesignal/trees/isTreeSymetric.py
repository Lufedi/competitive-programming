
from collections import deque
def isTreeSymmetric(t):
    if t == None: return True
    return isTreeMirror(t.left, t.right)
def isTreeMirror(tree1, tree2):
    if tree1 == None and tree2 == None: return True
    if tree1 == None or tree2 == None: return False
    return isTreeMirror(tree1.left, tree2.right) and isTreeMirror(tree1.right, tree2.left)


'''
iterative solution 

def isTreeSymmetric(t):
    
    if t == None: return True
    
    q1,q2 = [t.left],[t.right]
    
    while q1 and q2:
        n1 = q1.pop()
        n2 = q2.pop()
        
        
        if n1 == None and n2 == None: continue
        if n1 == None or n2 == None: return False
        if n1.value != n2.value: return False
        
        q1.append(n1.left)
        q2.append(n2.right)
        
        q1.append(n1.right)
        q2.append(n2.left)
        
    return len(q1) == 0 and len(q2) == 0

'''