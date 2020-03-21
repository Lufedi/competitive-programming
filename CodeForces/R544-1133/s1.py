INF  = 1000000000000000000
def main(nums, repl):
    sums = [nums[0]]
    for i in range(1, len(sums)):
        sums[i]+= sums[i]
    replSum  = 0
    for i in repl:
        replSum+= 0
    answer = (INF , INF)
    for i in range(len(repl)-1, len(nums)):
        segmentSum = sums[i]-sums[i-1]
        difference =abs(segmentSum - replSum)
        if difference < answer :
            answer = (difference, i)
        elif difference == answer:
            answer = ( answer[0] , min(answer[1], i))
        else:
            continue
        

