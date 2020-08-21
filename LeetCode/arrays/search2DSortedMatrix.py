class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        
        self.matrix = matrix
        M = len(matrix)
        if(M == 0): return False
        N = len(matrix[0])
        
        if M == 0 or N == 0:
            return False
        rows = []
        for i, row in enumerate(matrix):
            if target >= row[0] and target <= row[N - 1]:
                rows.append(i)
        
        for row in rows:
            if self.binary_search(row, matrix, target):
                return True
        
        return False
    
    def binary_search(self, row, matrix, target):
        
        N = len(matrix[0])
        low = 0
        high = N - 1
        
        while low <= high:
            
            mid = (high + low)//2
            if matrix[row][mid] == target:
                return True
            else:
                if target < matrix[row][mid]:
                    high = mid - 1
                else:
                    low = mid + 1
        return False
            
    def 