class Solution:
    # @param A : list of integers
    # @return a list of list of integers
    def permute(self, A):
        self.solutions = {}
        return self.permutateBack(A)
        
    def permutateBack(self, A):
        if len(A) == 1:
            return [A]
        if len(A) == 0:
            return []
        else:
            ans = []
            for i, elem in enumerate(A):
                res = [e for j,e in enumerate(A) if i != j]
                heads = self.permutateBack(res)
                for l in heads:
                    l.append(elem)
                ans += heads
            
            no_dup = []
            keys  = set()
            for s in ans:
                k = str(s)
                if not k in keys:
                    keys.add(k)
                    no_dup.append(s)
            ans = no_dup
            return ans

                

    def formKey(self, p):
        return "-".join([str(x) for x in p])
def main():
    s  = Solution()
    A = [1,1,2]
    print(s.permute(A))
   


main()