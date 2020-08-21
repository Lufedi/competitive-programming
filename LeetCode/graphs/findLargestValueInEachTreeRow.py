# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root == None:
            return []
        res = []
        queue = deque()
        queue.append(root)
        queue.append(None)
        local = 0
        while len(queue) > 0:
            
            node = queue.popleft()
            if node == None:
                res.append(local)
                local = 0
                if(len(queue) == 0):
                    break
                queue.append(None)
                continue
            local = max(local, node.val)
            if node.left != None:
                queue.append(node.left)
            if node.right != None:
                queue.append(node.right)
        return res





    