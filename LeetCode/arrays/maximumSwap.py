class Solution:
    def maximumSwap(self, num: int) -> int:
        
        
        nums = [int(c) for c in str(num)]
        L = len(nums)
        pairs = [None for i in range(L)]
        #print(nums)
            
        maxi = nums[-1]
        pairs[-1] = (nums[-1], L - 1)
        for i in range(L-2, -1, -1):
            if(nums[i] > maxi):
                pairs[i] = (nums[i], i)
                maxi = nums[i]
            else:
                pairs[i] = pairs[i+1]
        
        #print(pairs)
        swap = None
        for i in range(L):
            if pairs[i][0] > nums[i]:
                swap = (i, pairs[i][1])
                break
            else:
                continue
        #print(swap)
        
        if swap != None:
            nums[swap[0]], nums[swap[1]] = nums[swap[1]], nums[swap[0]]
        
        return ''.join([ str(d) for d in nums])
        