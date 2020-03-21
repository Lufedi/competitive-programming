class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    def diffPossible(self, A, B):
        if len(A) <= 1:
            return 0
        end = 0
        for ini in range(len(A)):
            while(end < len(A)-1 and A[end] - A[ini] < B ):
                end+=1
            if A[end] -  A[ini] == B and end != ini:
                return 1
        return 0
    """def diffPossible(self, A, B):
        a = {}
        for i,e in enumerate(A):
            a[e] = i
        for i,e in enumerate(A):
            key = e - B
            if key in a.keys() and a[key] != i:
                return 1
        return 0
    """