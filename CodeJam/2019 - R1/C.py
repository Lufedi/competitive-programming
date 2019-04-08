from sys import stdin
def SieveOfEratosthenes(n): 
    prime = [True for i in range(n+1)] 
    p = 2
    while (p * p <= n): 
        if (prime[p] == True):               
            for i in range(p * 2, n+1, p): 
                prime[i] = False
        p += 1
    res = []
    for p in range(2, n): 
        if prime[p]: 
            res.append(p)
    return res
def getPair(primes, n):
    found = []
    for i in range(len(primes)):
        if len(found) >= 2:
            break
        if n%primes[i] == 0:
            found.append(primes[i])
    return found
def main():
    c = int(stdin.readline().strip())
    primes = SieveOfEratosthenes(pow(11000,1))
    #print(primes[len(primes)-1], primes[len(primes)-2])
    memo = {}
    numsUsed = set()

    for k in range(c):
        N, L = [int(x) for x in stdin.readline().strip().split()]
        nums = [int(x) for x in stdin.readline().strip().split()]
        numsUsed.clear()
        for n in nums:
            founds = getPair(primes, n)
            memo[n] = founds
            numsUsed.add(memo[n][0])
            numsUsed.add(memo[n][1])
        numsUsedList = list(numsUsed)
        
        numsUsedList.sort()
        mappingPrimes = {}
        for i in range(len(numsUsedList)):
            letter = chr(65+i)
            mappingPrimes[numsUsedList[i]] = letter
        res = []
        #print(mappingPrimes)
        for i in range(len(nums)):

            if i == len(nums) - 1:
                p1 = memo[nums[i]]
                p2 = memo[nums[i-1]]
                if p1[0] in p2:
                    res.append(mappingPrimes[p1[0]])
                    res.append(mappingPrimes[p1[1]])
                else:
                    res.append(mappingPrimes[p1[1]])
                    res.append(mappingPrimes[p1[0]])
            else:
                p1 = memo[nums[i]]
                p2 = memo[nums[i+1]]
                if not p1[0] in p2:
                    res.append(mappingPrimes[p1[0]])
                elif not p1[1] in p2:
                    res.append(mappingPrimes[p1[1]])
                else:
                    res.append(mappingPrimes[p1[0]])
        print('Case #' + str(k+1) + ": " + ''.join(res))

main()