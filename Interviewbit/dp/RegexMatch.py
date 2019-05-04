class Solution:
    def isMatch(self, A,B):
        if not len(A) and not len(B):
            return 1
        if not len(B):
            return 0
        if len(B) - B.count('*') > len(A):
            return 0
        A = "@" + A
        B = "@" + B
        dp = [[None for j in range(len(B))] for i in range(len(A))]
        for i in range(len(A)):
            for j in range(len(B)):
                if i == 0 and j == 0:
                    dp[i][j] = True
                else:
                    if A[i] == B[j] or  B[j] == "?":
                            dp[i][j] = dp[i-1][j-1] if i > 0 and j > 0 else False
                    else:
                        if B[j] == "*":
                            dp[i][j] = dp[i][j] or ( dp[i-1][j] if i > 0 else False)
                            dp[i][j] = dp[i][j] or (dp[i-1][j-1] if i > 0 and j > 0 else False)
                            dp[i][j] = dp[i][j] or ( dp[i][j-1] if j >0 else False)
        return 1  if dp[len(A)-1][len(B)-1] else 0        
        #return 1 if self.match(len(A),len(B)) else 0
    """def match(self, i,j):
        if i == 0 and j==0:
            return True
        elif self.memo[i][j] != None:
            return self.memo[i][j]
        else:
            res = None
            if self.A[i] == self.B[j]:
                res = self.match(i-1,j-1) if i > 0 and j > 0 else False
            else:
                if self.B[j]=="?":
                    res = self.match(i-1,j-1) if i > 0 and j > 0 else False
                elif self.B[j]=="*":
                    res = res or ( self.match(i-1,j) if i > 0 else False)
                    res = res or (self.match(i-1,j-1) if i > 0 and j > 0 else False)
                    res = res or ( self.match(i, j-1) if j >0 else False)
                else:
                    res = False
            if i >=0  and j >= 0:
                self.memo[i][j] = res 
            return res
    """

def main():
    s = Solution()
    print(s.isMatch("aa","aa**") )
main()