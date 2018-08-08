

from sys import stdin
from functools import reduce, cmp_to_key

def comp(a, b):
    if(a[0] > b[0]):
        return -1
    elif a[0] == b[0]:
        if a[1] <= b[1]:
            return -1
        else:
            return 1
    else:
        return 1

def main():
    
    n = int(stdin.readline())
    students_scores = []
    for i in range(n):
        scores = [int(x) for x in stdin.readline().strip().split(" ")]
        total_score = reduce((lambda x, y: x + y), scores)
        #print(total_score)
        students_scores.append((total_score, i))

    students_scores.sort(key=cmp_to_key(comp))
    
    for i in range(n):
        if( students_scores[i][1] == 0):
            print(i+1)

main()
