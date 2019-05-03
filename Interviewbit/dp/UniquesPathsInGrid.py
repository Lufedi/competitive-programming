class Solution:
    # @param A : list of list of integers
    # @return an integer
    def __init__(self):
        self.M = 0
        self.N = 0
        self.A = None
        self.memo = None
    def uniquePathsWithObstacles(self, A):
        self.A = A
        self.M = len(A)
        if self.M <= 0:
            return 0
        self.N = len(A[0])
        self.memo = [[None for i in range(self.N)] for i in range(self.M)]
        return self.path(0,0)

    def path(self, i, j):
        if i >= self.M or j >= self.N or self.A[i][j] == 1 : 
            return 0
        elif self.memo[i][j] != None:
            return self.memo[i][j]
        elif i == self.M-1 and j == self.N-1:
            return 1
        else:
            ans = self.path(i+1,j) + self.path(i,j+1)
            self.memo[i][j] = ans
            return ans
        
def main():
    s = Solution()
    print(s.uniquePathsWithObstacles([[0]]))
main()