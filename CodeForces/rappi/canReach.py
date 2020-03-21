


def canReach(x1, y1, x2, y2):
    MAX_COORD = 1001
    plane = [ [False for x in range(MAX_COORD)] for x in range(MAX_COORD)]
    plane[x1][y1] = True
    for i in range(1,MAX_COORD):
        for j in range(1,MAX_COORD):
            if(plane[i][j]):
                nj = ni = i + j
                if(ni < MAX_COORD):
                    plane[ni][j] = True
                if(nj < MAX_COORD):
                    plane[i][nj] = True
    return "Yes" if plane[x2][y2] else "No"

            

print(canReach(1,2,2,1))