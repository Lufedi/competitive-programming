class Solution:
    def maxSubArray(self, A):
        if len(A) <= 0:
            return 0
        else:
            m = A[0]
            c = A[0]
            for i in range(1, len(A)):
                if c < 0:
                    c = 0
                c += A[i]
                m = max(m, c)
                
            return m
def main():
    s = Solution()
    A = [-2,1,-3,4,-1,2,1,-5,4]
    print(s.maxSubArray(A))
main()