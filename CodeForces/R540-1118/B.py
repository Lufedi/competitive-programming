from sys import stdin

def main():
    q = int(stdin.readline().strip())
    nums  = [int(x) for x in stdin.readline().strip().split()]
    sums = [(0,0)]

    for i in range(len(nums)):
        if i % 2 == 0:
            sums.append( (sums[i][0] + nums[i], sums[i][1]))
        else:
            sums.append( (sums[i][0], sums[i][1] + nums[i]))   
    total = 0
    for i in range(1, len(sums)):
        if sums[i-1][0] + (sums[len(sums)-1][1] - sums[i][1]) == sums[i-1][1] + (sums[len(sums)-1][0] - sums[i][0]):
            total+=1
    print(total)
main()
