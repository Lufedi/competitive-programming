from sys import stdin


def main():
    l = int(stdin.readline().strip())
    cad = stdin.readline().strip()
    
    nums = [int(a) for a in cad]
    L = l // 3
    counter = [L,L,L]

    for a in nums:
        counter[a] -= 1

    index = 0
    for i in range(0, l):
        print(counter)
        if nums[i] != index and counter[index] > 0:
            #counter[nums[i]] += 1 if counter[nums[i]] < L else -1
            counter[index] += 1 if counter[index] < L else -1
            nums[i] = index
        if counter[index] <= 0:
            index += 1
    print(''.join(str(e) for e in nums))

main()
