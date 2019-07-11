class Solution:
    # @param A : list of list of integers
    # @return the same list modified

    def rotate(self, A):
        L = len(A)
        for i in range(L//2):
            for j in range(i, L- i - 1):
                temp = A[i][j]
                A[i][j] = A[L-j-1][i]
                A[L-j-1][i] = A[L-i-1][L-j-1]
                A[L-i-1][L-j-1] = A[j][L-i-1]
                A[j][L-i-1] = temp
        return A
    

def main():
    s = Solution()
    a = [[31, 32, 228, 333],
         [79, 197, 241, 246],
         [77, 84, 126, 337],
         [110, 291, 356, 371]]
    for l in s.rotate(a):
        print(l)
main()
