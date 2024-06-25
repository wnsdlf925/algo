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