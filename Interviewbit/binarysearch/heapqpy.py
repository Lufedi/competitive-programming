import heapq


import math

def show_tree(tree, total_width=36, fill=' '):
    """Pretty-print a tree."""
    output = ""
    last_row = -1
    for i, n in enumerate(tree):
        if i:
            row = int(math.floor(math.log(i+1, 2)))
        else:
            row = 0
        if row != last_row:
            output+= '\n'
        columns = 2**row
        col_width = int(math.floor((total_width * 1.0) / columns))
        output += (str(n).center(col_width, fill))
        last_row = row
    print(output)
    print('-' * total_width)
    print()
    return


list = [25,1,3,2,36,7,17,19,100]

print('before heapify:')
print(list)
show_tree(list)

print('after heapify:')
heapq.heapify(list)
print(list)
show_tree(list)

print('before push:')
print(list)
show_tree(list)

print('after push:')
heapq.heappush(list, 4)
print(list)
show_tree(list)

print('after pop:')
heapq.heappop(list)
print(list)
show_tree(list)

