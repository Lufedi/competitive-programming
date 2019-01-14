
from sys import stdin
def main():
	n, d, r = [int(x) for x in stdin.readline().strip().split(" ")]
	arr = [int(x) for x in stdin.readline().strip().split(" ")]
#	n,d,r =[6,6,4]
#	arr=[1,2,6,10,3]
	if d > r:
		print(len(arr))
	else:
	    cont =0
	    for x in arr:
	        if x - d <= 0:
	            cont=cont+1
	    res= cont//2 if cont % 2 == 0 else cont//2+1
	    print(res)
main()