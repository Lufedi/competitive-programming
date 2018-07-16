


from sys import stdin


def main():

    n = int(stdin.readline().strip())
    numbers = [int(x) for x in stdin.readline().strip().split(" ")]

    right_sum = {}
    right_sum[0] = 0
    sum = 0
    for i in range(n):
        sum+= numbers[i]
        right_sum[sum] = i + 1


    left_sum = {}
    left_sum[0] = 0
    sum = 0
    for i in range(n):
        sum+= numbers[n-i-1]
        left_sum[sum] = n - i

    #print(right_sum)
    #print(left_sum)

    res = 0

    for key in right_sum:
        if( key in left_sum and right_sum[key] < left_sum[key]):
            res = max(res, key)

    print(res)

main()