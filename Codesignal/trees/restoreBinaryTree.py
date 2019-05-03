
class Tree(object):
    def __init__(self, x):
        self.value = x
        self.left = None
        self.right = None
    def __str__(self):
        return f'{self.value} l: \n {self.left} \n r:{self.right} \n'
    

def restoreBinaryTree(inorder, preorder):
    return restore(inorder, preorder)
    
def restore(inorder, preorder):
    if len(preorder) <= 0: return None
    head = preorder[0]
    sol = Tree(head)   
    if len(inorder) > 1:
        inind = find(head, inorder)
        right = inorder[inind+1:]
        left = inorder[0:inind]
        sol.left = restore(left, preorder[1:len(left)+1])
        sol.right = restore(right, preorder[len(left)+1:])
    sol.value = head
    return sol


def find(head, inorder):
    for i in range(len(inorder)):
        if inorder[i] == head:
            return i
    return -1

inorder = [4, 2, 1, 5, 3, 6]
preorder = [1, 2, 4, 3, 5, 6]

print(restoreBinaryTree(inorder, preorder))
