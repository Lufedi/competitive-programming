class Solution:


    def maxProfit(self, k, A):
        k = k * 2 
        L = len(A)
        dp =  [[None for i in range(k+1)] for j in range(L+1)]
        INF = -100000000000000
        for i in range(k+1):
            if i % 2 == 0:
                dp[L][i] = 0
            else:
                dp[L][i] = INF
        for i in range(L-1,-1,-1):
            for j in range(k,-1,-1):
                if j % 2 == 0:
                    dp[i][j] = max(-1*A[i] + (dp[i+1][j+1] if j < k else INF), dp[i+1][j])
                else:
                    dp[i][j] = max(A[i] + (dp[i+1][j+1] if j < k else INF), dp[i+1][j])
        return dp[0][0]
def main():
    s = Solution()
    A = [3,2,6,5,0,3]
    B = 2
    print(s.maxProfit(B,A))
    #print(s.maxProfit([5030607, 3485715, 2500526, 676233, 7968122, 7455631, 2382510] ))
    #print(s.maxProfit([1,2]))
main()
