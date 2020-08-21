class Solution:

    def productSpareVectors(self, vectorA, vectorB):

        values = {}
        for i,v in enumerate(vectorA):
            if i in values:
                values[i].append(v)
            else:
                values[i] = [v]
        
        for i,v in enumerate(vectorB):
            if i in values:
                values[i].append(v)
            else:
                values[i] = [v]
        

        res = 0
        for k in values:
            total = 1
            for num in values[k]:
                total*= num
            res+=total
        return res

c = Solution()
A = [1,0,0,0,4,0,1]
B= [ 0,0,0,0,3,0,0]
print(c.productSpareVectors(A, B))
        
                
