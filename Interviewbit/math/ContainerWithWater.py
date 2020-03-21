class Solution:
    # @param A : list of integers
    # @return an integer
    def maxArea(self, A):
        pend = len(A)-1
        pini = 0
        res = 0
        while(pend != pini):
            df = pend - pini
            res = max(res, df * min(A[pini], A[pend]))
            if A[pini] < A[pend]:
                pini+=1
            else:
                pend-=1
        return res

                
class Point:
    def __init__(self, value, index):
        self.value = value
        self.index = index
    def __lt__(self, other):
        if self.value < other.value:
            return False
        else:
            return True
    def __repr__(self):
        return str(self.value) + '-' + str(self.index)

def main():
    s = Solution()
    A = [1,5,4,3]
    print(s.maxArea(A))
main()