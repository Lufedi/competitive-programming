

import math
def cutWoods(woods, k):
    
    left = 0
    right = max(woods)
    res = 0
    while(left < right):
        
        mid = (left + right ) // 2
        if(isValid(mid, woods, k)):
            left+=1
            res = max(res, mid)
        else:
            right-=1
    return res

def isValid(cut, woods, target):
    
    k = 0
    for wood in woods:
        if wood >= cut:
            k+= wood // cut
        else:
            return False
    return k >= target

woods = [232, 124, 456]
k = 7
print(cutWoods(woods, k))