from sys import stdin




def main():
    stdin.readline()
    s =  [int(c)  for c in stdin.readline().strip().split()]
   
    longest = 1
    cont = 1
    for i in range(1, len(s)):
        if(s[i] >= s[i-1]):
            cont+= 1
        else:
            cont = 1
            longest = max(longest, cont)
    print( max(longest, cont))

main()