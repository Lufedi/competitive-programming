#
# Definition for binary tree:
# class Tree(object):
#   def __init__(self, x):
#     self.value = x
#     self.left = None
#     self.right = None
def hasPathWithGivenSum(t, s):
    if t == None: return False
    q = [(t, t.value)]

    while len(q) != 0:
        pair= q.pop()
        node, acum = pair[0], pair[1]
        if node.left != None:
            q.append( (node.left, acum + node.left.value))
       
        if node.right != None:
            q.append( (node.right, acum + node.right.value))
        
        if node.left == None and node.right == None and acum == s: return True
    return False

    