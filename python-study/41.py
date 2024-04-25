def solution(graph,source):
    vertexNum = len(graph)
    distance = [float("inf")]*vertexNum

    distance[source] = 0
    prenode = [None]*vertexNum
    

    for z in range(vertexNum):
        for i in range(vertexNum):
            for j in graph[i]:
                if distance[j[0]] > distance[i]+j[1]:
                    distance[j[0]] = distance[i]+j[1]
                    prenode[j[0]] = i
                    if z == vertexNum-1:
                        return print(-1)
                        
    

    return [distance,prenode]




# TEST 코드 입니다. 주석을 풀고 실행시켜보세요
print(solution([[(1, 4), (2, 3), (4, -6 )], [(3, 5)], [(1, 2)], [(0, 7), (2, 4)],[(2, 2)]],0)) #반환갑 : [[0, -2, -4, 3, -6], [None, 2, 4, 1, 0]]
print(solution([[(1, 5), (2, -1)], [(2, 2)], [(3, -2)], [(0, 2), (1, 6)]],0)) # 반환값 : [-1]