class BSTIterator():
    def __init__(self, t):
        self.ar = []
        self.build(t)
    def build(t):
        if t == None:
            return []
        else:
            return build(t.left)+[t.val] + build(t.right)
        

        
