class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        
        if len(nums) == 1:
            return  1 if nums[0] == k else 0
        
        '''
        res = 0
        L = len(nums)
        for start in range(L):
            acum = 0
            for end in range(start,L):
                acum += nums[end]
                if acum == k:
                    res+=1
        return res
        '''
        L = len(nums)
        count_sums = {}
        count_sums[0] = 1
        acum = 0
        res = 0
        for i in range(L):
            acum += nums[i]
            if acum - k in count_sums:
                res += count_sums[acum - k]
            if acum in count_sums:
                count_sums[acum] += 1
            else:
                count_sums[acum] = 1
        return res
    
            