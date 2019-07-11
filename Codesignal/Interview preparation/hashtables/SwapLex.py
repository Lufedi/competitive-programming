def swapLexOrder(strIn, pairs):
    
    if not pairs:
        return strIn

    # vertex to connections
    connected = {}
    for pair in pairs:
        pair.sort()
        if not pair[0] in connected:
            connected[pair[0]] = set()
        if not pair[1] in connected:
            connected[pair[1]] = set()
        connected[pair[0]].add(tuple(pair))
        connected[pair[1]].add(tuple(pair))

    components = []
    vertices = set(connected)
    while len(vertices) > 0:
        startVertex = list(vertices)[0]
        componentVertices = traverse(startVertex, connected.copy(), set())
        components.append(componentVertices)
        vertices -= componentVertices
        
    #sets
    strList = list(strIn)
    for componentSet in components:
        compList = list(componentSet)
        compList.sort()
        chars = [strList[index-1] for index in compList]
        chars.sort(reverse=True)
        for i, strIndex in enumerate(compList):
            strList[strIndex - 1] = chars[i]
            
    return ''.join(strList)


def traverse(startVertex, nodes, visited):
    if startVertex in visited:
        return visited
    connections = nodes[startVertex]
    visited.add(startVertex)
    for connection in connections:
        if not connection[0] in visited:
            visited |= traverse(connection[0], nodes, visited)
        if not connection[1] in visited:
            visited |= traverse(connection[1], nodes, visited)
    return visited