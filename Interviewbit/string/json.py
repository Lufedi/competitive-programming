"""
Input : ["foo", {"bar":["baz",null,1.0,2]}]
Output : 
[
    "foo", 
    {
        "bar":
        [
            "baz", 
            null, 
            1.0, 
            2
        ]
    }
]
"""
class Solution:
    # @param A : string
    # @return a list of strings
    def prettyJSON(self, A):
        res = []
        lvl = 0
        for i in range(len(A)):
            if A[i] == "[":
                res.append("\t"*lvl + "[")
                lvl+=1
            elif A[i] == "]":
                res.append("\t"*lvl + "]")
                lvl-=1

                
