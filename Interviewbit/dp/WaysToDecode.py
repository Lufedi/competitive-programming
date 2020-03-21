class Solution:
    def __init__(self):
        self.memo= []

    def numDecodings(self, n):
        self.memo = [None for i in range(len(n))]
        return self.f(n,0)
    def f(self, n, i):
        if len(n) == 0:
            return 0
        elif i == len(n):
            return 1
        elif self.memo[i]:
            return self.memo[i]
        else:
            res = 0
            res += self.f(n, i+1) if self.isValid(n[i]) else 0
            if i < len(n) - 1:
                res+= self.f(n,i+2) if self.isValid(n[i]+n[i+1])  else 0
            self.memo[i] = res
            return res
    def isValid(self, num):
        if(num[0] == '0'): return False
        num = int(num)
        return num > 0 and num < 27




memo = []
n = ''
def numDecodings(c):
    global memo, n
    memo = [None for i in range(len(c))]
    n = c
    return f(0)

def f(i):
    global memo
    if len(n) == 0:
        return 0
    elif i == len(n):
        return 1
    elif memo[i]:
        return memo[i]
    else:
        res = 0
        res += f( i+1) if isValid(n[i]) else 0
        if i < len(n) - 1:
            res+= f(i+2) if isValid(n[i]+n[i+1])  else 0
        memo[i] = res
        return res
def isValid( num):
    if(num[0] == '0'): return False
    num = int(num)
    return num > 0 and num < 27


def main():
    s = Solution()
    print(numDecodings('5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190'))
    
            
            
main()
