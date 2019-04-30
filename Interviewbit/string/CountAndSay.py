class Solution:
    def parse(self, sequence):
        sequence.append('|')
        counter = 1
        curr_letter = sequence[0]
        res = []
        for i in range(1, len(sequence)):
            if sequence[i] == sequence[i-1]:
                counter += 1
            else:
               res.append(str(counter))
               res.append(curr_letter)
               counter = 1
               curr_letter = sequence[i]
        return res
    def countAndSay(self, A):
        newsol = []
        currsol = ["1"]
        if A == 1: return "1"
        for i in range(A-1):
            newsol = self.parse(currsol)
            currsol = newsol
        return ''.join(newsol)
def main():
    s = Solution()
    print(s.countAndSay(6))

main()
               




