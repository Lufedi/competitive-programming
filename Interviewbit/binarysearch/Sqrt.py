class Solution:
    # @param A : integer
    # @return an integer
    def sqrt(self, A):
        return self.srqrtHelper(A,0,A)
    def srqrtHelper(self, value, low, high):
        if value == 0 or value == 1:
            return value
        mid = (low+high)//2
        if mid ** 2 == value:
            return mid
        if (low  + 1 == high) and low**2 <= value and high**2 > value:
            return low
        if(high < low):
            return mid
        if mid**2 >= value:
            return self.srqrtHelper(value, low, mid)
        else:
            return self.srqrtHelper(value, mid, high)

def main():
    s = Solution()
    print(s.sqrt(4))

main()