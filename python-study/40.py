from collections import deque

def solution(graph,start):
    graphs = {i: float("inf") for i in graph}
    visited = set()
    que = deque()

    graphs[start] = 0
    que.append(start)
    path = {start: [start]}
    
    

    while que:
        node = que.popleft()
        visited.add(node)
        for i in graph[node]:
            
            if graphs[node]+graph[node][i] and graphs[node]+graph[node][i]<graphs[i]:
                graphs[i] = graphs[node]+graph[node][i]
                que.append(i)
                path[i] = path[node]+[i]


    return print(graphs,path)







print(solution({ 'A': {'B': 9, 'C': 3}, 'B': {'A': 5}, 'C': {'B': 1} },'A')) # 반환값 :[{'A': 0, 'B': 4, 'C': 3}, {'A': ['A'], 'B': ['A', 'C', 'B'], 'C': ['A', 'C']}]
print(solution({'A': {'B': 1},'B': {'C': 5},'C': {'D': 1},'D': { } }, 'A')) # 반환값 :[{'A': 0, 'B': 1, 'C': 6, 'D': 7}, {'A': ['A'], 'B': ['A', 'B'], 'C': ['A', 'B', 'C'], 'D': ['A', 'B', 'C', 'D']}]