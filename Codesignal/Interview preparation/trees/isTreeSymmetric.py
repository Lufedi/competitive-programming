#
# Definition for binary tree:
# class Tree(object):
#   def __init__(self, x):
#     self.value = x
#     self.left = None
#     self.right = None
#
# Definition for binary tree:
# class Tree(object):
#   def __init__(self, x):
#     self.value = x
#     self.left = None
#     self.right = None
#     

def isTreeSymmetric(t):

    if t == None: return True
    res = inorder(t)
    size = len(res)
    mid = size//2 if size%2 == 0 else (size//2) + 1
    for i in range(mid):
        if res[i] != res[size - i  -1]:
            return False
    return True
def inorder(n):
    if n == None: return ['-2000']
    s = [str(n.value) if n != None else '-2000']
    left = inorder(n.left) if n.left != None else ['n']
    right = inorder(n.right) if n.right != None else ['n']
    return right + s + left


print(isTreeSymmetric(t))