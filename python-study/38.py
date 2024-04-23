from collections import defaultdict
def solution(graphs,start):
    global answer
    global visited
    answer = []
    graph = defaultdict(list)
    visited = set()
    for a, b in graphs:
        graph[a].append(b)
        visited.add(a)
        visited.add(b)

    
    def recursive(graph,num):
        if num in visited:
            answer.append(num)
            visited.remove(num)
        for i in graph[num]:
            recursive(graph,i)
    
    recursive(graph,start)
    
    return answer







# print(solution([['A', 'B'], ['B', 'C'], ['C', 'D'], ['D', 'E']], 'A')) # 반환값 : ['A', 'B', 'C', 'D', 'E']
print(solution([['A', 'B'], ['A', 'C'], ['B', 'D'], ['B', 'E'], ['C', 'F'], ['E', 'F']], 'A')) # 반환값 : ['A', 'B', 'D', 'E', 'F', 'C']