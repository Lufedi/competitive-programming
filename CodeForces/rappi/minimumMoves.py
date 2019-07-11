'''long totalMoves = 0;

        for (int i = 0; i < a.size(); i++) {
            long n1 = a.get(i);
            long n2 = m.get(i);
            int size = (n1 + "").length();
            for (int j = 0; j < size; j++) {

                long d1 = n1 % 10;
                long d2 = n2 % 10;

                totalMoves += Math.abs(d1 - d2);
                n1 = (int) n1 / 10;
                n2 = (int) n2 / 10;
            }
        }

        return (int) totalMoves;
'''

def minimumMoves(a, m):
    total_moves = 0
    for  i in range(len(a)):
        n1 = a[i]
        n2 = m[i]
        size = len(str(n1))
        for j in range(size):
            d1 = n1 % 10
            d2 = n2 % 10
            total_moves += abs(d1 - d2)
            n1 = n1 // 10
            n2 = n2 // 10
    return total_moves
            
