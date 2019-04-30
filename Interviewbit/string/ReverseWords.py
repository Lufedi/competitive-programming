
class Solution():
    def reverseWords(self, w):
        tokens = []
        token = []
        for i in range(len(w)):
            if w[i] == ' ':
                tokens.append(token)
                token = []
            else:
                token.append(w[i])
        if len(token) > 0:
            tokens.append(token)
        
        words = []
        print(tokens)
        for i in range(len(tokens)-1, -1, -1):
            words.append(''.join(tokens[i]))
        return " ".join(words)
        
            
#def main():
#    s = Solution()
#    print(s.reverseWords("this is gonna bed"))
#main()
