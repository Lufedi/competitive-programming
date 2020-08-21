# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        if root != None and root.val != None:
            self.process(root)
        
        
    def process(self, node):
        self.stack.append(node)
        if node.left != None:
            self.process(node.left)
                
    def next(self) -> int:
        """
        @return the next smallest number
        """
        #print(self.stack)
        if len(self.stack) == 0:
            return None
        
        node = self.stack.pop()
        
        if node.right != None:
            self.process(node.right)
        return node.val
            
        
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.stack) != 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()