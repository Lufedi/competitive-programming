from sys import stdin
def main():
    n = int(stdin.readline().strip())
    for c in range(n):
        p = int(stdin.readline().strip())
        words = []
        for _p in range(p):
            words.append((str(_p)+ stdin.readline().strip())[::-1])
        ws = {}
        for w in words:
            ws[w] = (0, "")
        for i in range(len(words)):
            for j in range(i+1, len(words)):
                lp = longestPrefix(words[i], words[j])
                llp = len(lp)
                ws[words[i]] = (llp, lp, words[j], words[i]) if llp > ws[words[i]][0] else ws[words[i]]
                ws[words[j]] = (llp, lp, words[i], words[j]) if llp > ws[words[j]][0] else ws[words[j]]
        vs = list(ws.values())
        
        vs.sort()
        vs = vs[::-1]
        used = {}
        res = 0
        for k in range(len(vs)):
            if vs[k][1] != "" and not vs[k][1] in used :
                res+=2
                used[vs[k][1]] = True
        
            

        print('Case #' + str(c+1) + ': ' +  str(res) )              
def longestPrefix(w1, w2):
    j = 0
    key = [""]
    while j< len(w1) and j < len(w2) and w1[j] == w2[j]:
        key.append(w1[j])
        j+=1
    return ''.join(key[::-1])
main()