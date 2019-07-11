class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    def threeSumClosest(self, A, B):
        A.sort()
        best = [0,1000000000000000]
        for i in range(len(A)-1):
            j = i + 1
            k = len(A) -1

            while k > j:
                if abs(A[i] + A[j] + A[k] - B) < best[1]:
                    best = [A[i] + A[j] + A[k], abs(A[i] + A[j] + A[k] - B)]
                if A[i] + A[j] + A[k] > B:
                    k-=1
                else:
                    j+=1
        return best[0]
            
                
def main():
    s = Solution()
    A = [ 2, 1, -9, -7, -8, 2, -8, 2, 3, -8 ]
    B = -1
    print(s.threeSumClosest(A, B))
main()