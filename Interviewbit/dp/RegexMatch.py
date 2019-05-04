class Solution:
    def __init__(self):
        self.A = None
        self.B = None
    def isMatch(self, A,B):
        self.A = A
        self.B = B
        return 1 if match(0,0) else 0
    def match(i,j):
        if i == len(self.A) and j==len(self.B):
            return True
        else:
            if self.A[i] == self.B[j]:
                return self.match(i+1,j+1)
            else:
                if self.B[j]=="?":
                    return self.match(i+1,j+1)
                elif self.B[j]=="*":
                    return self.match(i+1,j) or self.match(i+1,j+1)
                else:
                    return False

def main():
    s = 
