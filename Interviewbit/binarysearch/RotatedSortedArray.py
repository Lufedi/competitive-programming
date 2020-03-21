class Solution:

    def search(self, A, B):
        return self.binary_search(0, len(A)-1,A, B)

    def binary_search(self, low, high, A, B):
        
        if low >= high:
            return -1
        mid = (low + high)//2
        if A[mid] == B: return mid
        if A[mid] <= A[high]:
            if B >= A[mid] and B < A[high]:
                return self.binary_search(mid+1, high, A, B)
            else:
                return self.binary_search(low, mid, A, B)
        else:
            if (B <= A[mid] and B > A[high]) or (B <= A[mid] and B >= A[low]):
                return self.binary_search(low, mid, A, B)
            else:
                return self.binary_search(mid+1, high, A, B)


def main():
    s = Solution()
    A = [ 4,5,6,7,0,1]
    B = 4
    print(s.search(A, B))
main()