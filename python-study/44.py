import heapq
def solution(N, road, K):
    answer = 0
    graph = [[] for _ in range(N+1)]
    heap = []
    distance = [float("inf") for _ in range(N+1)]
    distance[1] = 0
    
    heapq.heappush(heap,(0,1))
    
    for i in road:
        graph[i[0]].append((i[1],i[2]))
        graph[i[1]].append((i[0],i[2]))

    while heap:
        cost, index = heapq.heappop(heap)

        for i in graph[index]:
            if distance[i[0]] > distance[index]+i[1]:
                distance[i[0]] = distance[index]+i[1]
                heapq.heappush(heap,(distance[i[0]],i[0]))

    for i in distance:
        if i <= K:
            answer+=1

    return answer


print(solution(5,[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]],3))