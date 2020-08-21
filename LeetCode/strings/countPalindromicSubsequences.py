
'''
Avoid duplacte cases not covered
'''
class Solution(object):


    def __init__(self):
        self.memo = {}
        self.S = ''
    def countPalindromicSubsequences(self, S):
        self.S = S
        return self.count(0, len(S)-1)
        '''
        count(i,j) =  
                        if S[i] == S[j] -> 1 + count(i + 1, j) + count(i, j - 1)
                        else -> count(i + 1, j) + count(i + 1, j - 1) + count(i, j - 1)     
        '''
    def count(self, i, j):
        if (i, j) in self.memo:
            return self.memo[(i, j)]
        res = 0
        if i == j:
            return 0
        if i > j:
            return 0
        print(i, j)
        if self.S[i] == self.S[j]:
            res = 1 + self.count(i + 1, j) + self.count(i, j - 1)
        else:
            res = self.count(i + 1, j) + self.count(i + 1, j - 1) + self.count(i, j - 1)
        self.memo[(i, j)] = res
        return res