class Solution():
    def strStr(self, a, b):
        if a == -1 or b == -1:
            return -1
        if len(a) > len(b):
            return -1
        for i in range(0, len(b)-len(a) + 1):
            isSub = True
            for j in range(len(a)):
                if b[i+j]!=a[j]:
                    isSub=False
            if isSub:
                return i
