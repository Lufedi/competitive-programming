from sys import stdin

def main():
    N,k = [ int(x) for x in stdin.readline().strip().split(" ")]
    arr = [ int(x) for x in stdin.readline().strip().split(" ")]

    countNumbers = {}
    for n in arr:
        if n in countNumbers:
            countNumbers[n]= countNumbers[n] + 1
        else:
            countNumbers[n] =  1

 
    res = [-1 for x in arr]
    isValid = True
    for key in countNumbers:
        if countNumbers[key] > k:
            isValid = False
    if(not isValid):
        print("NO")
    else:
        
        filledNumbers = 0
        colorsDict = {}
        color = 1
        n = 0
        
        for i in range(0, len(arr)):
            if not arr[i] in colorsDict:
                colorsDict[arr[i]]= color
                color = (color % k ) + 1
            else:
                colorsDict[arr[i]]= (colorsDict[arr[i]]%k)+1
                color = (color  % k ) + 1
            res[i]=colorsDict[arr[i]]
                
        print("YES")
        print(' '.join(str(e) for e in res))


main()

'''
4 2
1 2 2 3
outputCopy
YES
1 1 2 2
inputCopy
5 2
3 2 1 2 3
outputCopy
YES
2 1 1 2 1
inputCopy
5 2
2 1 1 2 1'''

'''
4 2
1 2 2 3
outputCopy
YES
1 1 2 2
inputCopy
5 2
3 2 1 2 3
outputCopy
YES
2 1 1 2 1
inputCopy
5 2
2 1 1 2 1'''