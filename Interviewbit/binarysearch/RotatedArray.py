class Solution:
    # @param A : tuple of integers
    # @return an integer
    def findMin(self, A):
        
        s  =  self.searchMin(A, 0, len(A)-1)
        return A[s]
    def searchMin(self, A, low, high):
        mid = (low+high)//2
        if A[low] <= A[high]:
            return low
        elif self.isPivot(A,mid):
            return mid
        else:
            if A[mid] <= A[high]:
                return self.searchMin(A, low, mid - 1)
            else:
                return self.searchMin(A, mid + 1, high)
    def isPivot(self, A, mid):
        prev = mid - 1 if mid != 0 else len(A) - 1
        nxt =  mid + 1 if mid != len(A) -1 else 0
        return A[prev] > A[mid] and A[nxt] > A[mid]
def main():
    s = Solution()
    A = [ 40342, 40766, 41307, 42639, 42777, 46079, 47038, 47923, 48064, 48083, 49760, 49871, 51000, 51035, 53186, 53499, 53895, 59118, 60467, 60498, 60764, 65158, 65838, 65885, 65919, 66638, 66807, 66989, 67114, 68119, 68146, 68584, 69494, 70914, 72312, 72432, 74536, 77038, 77720, 78590, 78769, 78894, 80169, 81717, 81760, 82124, 82583, 82620, 82877, 83131, 84932, 85050, 85358, 89896, 90991, 91348, 91376, 92786, 93626, 93688, 94972, 95064, 96240, 96308, 96755, 97197, 97243, 98049, 98407, 98998, 99785, 350, 2563, 3075, 3161, 3519, 4176, 4371, 5885, 6054, 6495, 7218, 7734, 9235, 11899, 13070, 14002, 16258, 16309, 16461, 17338, 19141, 19526, 21256, 21507, 21945, 22753, 25029, 25524, 27311, 27609, 28217, 30854, 32721, 33184, 34190, 35040, 35753, 36144, 37342 ]
    print(s.findMin(A))
main()
