class P:
    def __init__(self, message="hola", age=0):
        self.message = message
        self.age = age
    def __str__(self):
        return self.message + ' ' + str(self.age)    
a = []
a.append(P('a', 87))
a.append(P('b', 70))
a.append(P('c', 60))
a.append(P('d', 50))

a.sort(key=lambda e : e.message)

for i in a:
    print(i)