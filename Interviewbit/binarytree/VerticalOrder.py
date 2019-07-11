from collections import deque
class Solution:

    def verticalOrderTraversal(self, A):
        distance = {}
        queue = deque()
        if A == None:
            return []
        
        queue.append((A, 0 ))

        while len(queue):
            node, dis = queue.pop()
            if not dis in distance:
                distance[dis] = []
            distance[dis].append(node.val)

            if node.left:
                queue.appendleft((node.left, dis-1))
            if node.right:
                queue.appendleft((node.right, dis+1))
        
        
        res = [[] for i in range(len(distance))]
        for i,key in enumerate(sorted(distance.keys())):
            res[i] = distance[key]
            
        return res
