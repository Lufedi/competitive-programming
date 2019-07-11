class Solution:
    # @param A : tuple of integers
    # @return an integer
    def maxProfit(self, A):
        INF = 100000000000000000
        res = [INF,0]
        for i in range(len(A)):
            res[1] = max(res[1], A[i] - res[0])
            res[0] = min(res[0], A[i])
        return res[1]
def main():
    s = Solution()
    print(s.maxProfit([2,1]))
main()