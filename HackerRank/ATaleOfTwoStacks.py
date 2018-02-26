from collections import deque
from sys import stdin

q = deque()
lines= int(stdin.readline().strip())
for i in range(lines):
    ops = [int(elem) for elem in stdin.readline().strip().split()]
    if ops[0] == 1:
        q.appendleft(ops[1])
       
    elif ops[0] == 2:
        q.pop()
   
    else:
        print(q[len(q) -1])