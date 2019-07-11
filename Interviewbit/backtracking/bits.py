a = 29
print(a, bin(a))
while a != 0:
    print(a, bin(a), (a&1)) # check if firt bit is on or not
    a = a >> 1

