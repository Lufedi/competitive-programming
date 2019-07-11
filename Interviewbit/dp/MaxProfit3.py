class Solution:
    # @param A : tuple of integers
    # @return an integer

    # @param A : tuple of integers
    # @return an integer
    def maxProfit(self, A):
        if(len(A)<=1): return 0
        mini, maxi = A[0], 0
        ini = [0 for i in range(len(A))]
        end = [0 for i in range(len(A))]
        for i in range(1,len(A)):
            mini = min(mini, A[i])
            ini[i] = max(ini[i-1], A[i]-mini)
        
        end[len(A)-1] = 0
        maxi = A[len(A)-1]
        for i in range(len(A)-2,-1,-1):
            maxi = max(maxi,A[i])
            end[i] = max(end[i+1], maxi - A[i])
        maximum = 0
        for i in range(len(A)):
            maximum = max(maximum, ini[i]+end[i])
        return maximum
    """
    def maxProfit(self, A):
        L = len(A)
        dp =  [[None for i in range(L+1)] for j in range(L+1)]
        INF = -100000000000000
        for i in range(L+1):
            if i > 4:
                dp[L][i] = INF
            else:
                if i % 2 == 0:
                    dp[L][i] = 0
                else:
                    dp[L][i] = INF
        for i in range(L-1,-1,-1):
            for j in range(L,-1,-1):
                if j % 2 == 0:
                    dp[i][j] = max(-1*A[i] + (dp[i+1][j+1] if j < L else INF), dp[i+1][j])
                else:
                    dp[i][j] = max(A[i] + (dp[i+1][j+1] if j < L else INF), dp[i+1][j])
        return dp[0][0]
    """
def main():
    s = Solution()
    A = [ 4325739, 9497384, 5599992, 6046395, 6530234, 9453468, 9756537, 7432531, 8351721, 2423356, 2673467, 5269140, 4012918, 1424984, 829769, 6451835, 58862, 3891122, 195334, 8250617, 5869608, 8034044, 7450595, 6527099, 8869161, 9280891, 2945072, 3828462, 4699696, 5763641, 4646726, 9505933, 2720462, 368995, 5036783, 3362576, 8668469, 7945088, 4749548, 8727258, 6189765, 532118, 3875759, 3174178, 9096432, 7795666, 6796464, 9493096, 6170981, 3668923, 9239950, 8379417, 6835275, 4306075, 1558528, 7703680, 1150411, 692578, 480655, 6660302, 336987, 1320255, 7095760, 3571449, 8262583, 9180004, 3985823, 5536209, 6661193, 7927595, 1069829, 1188291, 3719791, 8947591, 7656042, 9344870, 369870, 3573846, 5135736, 4476683, 2048233, 3194755, 630549, 7695472, 9908572, 62559, 3951965, 2157153, 4782326, 8086578, 1635421, 6415535, 8239517, 8900992, 5062104, 9202855, 3530393, 4115809, 3586522, 6818829, 8641002, 6368877, 2702560, 7525140, 5156525, 2778444, 7775655, 6469411, 2990537, 3183001, 2307661, 4695526, 7427985, 1241677, 4740748, 9579696 ]
    B = [1,2,1,2,1,10]
    print(s.maxProfit(A))
    #print(s.maxProfit([5030607, 3485715, 2500526, 676233, 7968122, 7455631, 2382510] ))
    #print(s.maxProfit([1,2]))
main()
