from collections import deque

def solution(info, edges):

    que = deque()
    max_sheep = 0
    graph = dict()
    

    for i in range(len(info)):
        graph[i] = []

    for i in edges:
        a,b = map(int, i)
        graph[a].append(b)
    
    # 현재노드, 양 수, 늑대 수, 방문노드 셋
    que.append((0,1,0,set()))

    while que:
        now_node, sheep_count, wolf_count, visited_set = que.popleft()
        visited_set.update(graph[now_node])
        
        max_sheep = max(max_sheep,sheep_count)

        for i in visited_set:
            if info[i] == 1:
                if sheep_count > wolf_count+1:
                    que.append((i,sheep_count,wolf_count+1,visited_set - {i}))
                
            else:
                que.append((i,sheep_count+1,wolf_count,visited_set - {i}))
    


    return max_sheep

print(solution([0,0,1,1,1,0,1,0,1,0,1,1],[[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]))

# set은 튜플이기 때문에 반복문에서 변화가 불가 차집합으로 새로운 집합을 반환해야함