from collections import deque

def swapLexOrder(cad, pairs):
    memo = {}
    s = list(cad)
    q = deque()
    memo[''.join(cad)] = True
    for pair in pairs:
        s[pair[0]-1] , s[pair[1]-1] = s[pair[1]-1] , s[pair[0]-1]
        key = ''.join(s)
        memo[key] = True
        q.append(s[:])
        s[pair[0]-1] , s[pair[1]-1] = s[pair[1]-1] , s[pair[0]-1]

    while len(q) != 0:
        node = q.pop()
        key = ''.join(node)
        for pair in pairs:
            node[pair[0]-1] , node[pair[1]-1] = node[pair[1]-1] , node[pair[0]-1]
            k = ''.join(node)
            if not k in memo:
                memo[k] = True
                q.append(node[:])
            node[pair[0]-1] , node[pair[1]-1] = node[pair[1]-1] , node[pair[0]-1]
    keys = [k for k in memo.keys()]
    keys.sort()
    return keys[len(keys)-1]

s = "abdc"
p =   [[1, 4], [3, 4]]
swapLexOrder(s, p)

