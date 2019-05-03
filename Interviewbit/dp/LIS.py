#n**2
class Solution:
    # @param A : tuple of integers
    # @return an integer
    def lis(self, A):
        dp = [1 for i in range(len(A))]
        for i in range(1,len(A)):
            for j in range(i):
                if A[i] > A[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)