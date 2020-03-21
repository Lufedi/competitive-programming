'''

7
a 	100100
b	100101
c	110001
d	100000
[newline]	111111
p	111110
q	000001
111110000001100100111111100101110001111110

pqa
bcp
'''

def decode(codes, encoded):
    map_substrings = {}
    map_codes = {}
    L = len(encoded)
    JUMP_LINE = "[newline]"
    for code in codes:
        data = code.split("\t")
        map_codes[data[1]] = data[0]
    
    head = 0
    res = ""
    for i in range(L+1):
        #print(encoded[head:i])
        if(encoded[head:i] in map_codes):
            if(map_codes[encoded[head:i]] == JUMP_LINE):
                print()
            else:
                print(map_codes[encoded[head:i]], end = '')
            head = i
       
    
sol = ["a	100100",
    "b	100101",
    "c	110001",
    "d	100000",
    "[newline]	111111",
    "p	111110",
    "q	000001"]
encoded = "111110000001100100111111100101110001111110"

decode(sol, encoded)