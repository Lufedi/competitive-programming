
#Round 496 - 1005A


from sys import  stdin

def main():
    stdin.readline()
    line = [int(x)  for x in stdin.readline().strip().split()]
    line.append(1)
    cont = 1
    stairs = []
    for i in range(len(line)-1):
        if line[i+1] == 1:
            stairs.append(cont)
            cont =1
        else:
            cont+=1

    print(len(stairs))
    for i in range(len(stairs)):
        print(stairs[i], end='')
        if(i != len(stairs)): print(' ', end='')

main()
