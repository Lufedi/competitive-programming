class Solution:
    def __init__(self):
        self.memo= []
    
    def numsDecodings(self, n):
        self.memo = [None for i in range(len(n))]
        return self.f(n,0)
    def f(self, n, i):
        if len(n) == 0:
            return 0
        elif i == len(n):
            return 0
        elif self.memo[i]:
            return self.memo[i]
        else:
            res = 0
            res += 1 + self.f(n, i+1) if n[i] != '0' else 0
            if i < len(n) - 2 and n[i] != '0':
                couple = int(n[i]+n[i+1])
                res+= 1 + self.f(n,i+2) if couple < 26 else 0
            self.memo[i] = res
            return res
def main():
    s = Solution()
    print(s.numsDecodings('12'))
    
            
            
main()
