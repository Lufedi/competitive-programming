from sys import stdin
def replace(c,n):
    for i in range(1,len(c[0]),2):
        for j in range(1,5):
            if n>0:
                c[j][i]=c[j][i].replace("#","O")
                if c[j][i]=="O":
                    n=n-1
    return c       
def main():
    a1=[]
    bus=[["+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","+"],
         ["|","#",".","#",".","#",".","#",".","#",".","#",".","#",".","#",".","#",".","#",".","#",".","|","D","|",")"],
         ["|","#",".","#",".","#",".","#",".","#",".","#",".","#",".","#",".","#",".","#",".","#",".","|",".","|"],
         ["|","#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","|"],
         ["|","#",'.','#','.','#','.','#','.','#','.','#','.','#','.','#','.','#','.','#','.','#','.','|','.','|',')'],
         ['+','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','+']]
    n=int(stdin.readline())
    bus=replace(bus,n)
    for i in range(0,len(bus)):
        print("".join(bus[i]))
main()