
def solution(n, wires):
    global graph
    global visited
    answer = float("inf")
    graph = dict()
    visited = set()

    
    for i in range(1,n+1):
        graph[i] = []

    for a,b in wires:
        
        graph[a].append(b)
        graph[b].append(a)


    for a,b in wires:
        graph[a].remove(b)
        graph[b].remove(a)
        dfs(1)
        temp = abs(n-len(visited))
        if abs(temp-len(visited))<answer:
            answer = abs(temp-len(visited))
        visited.clear()
        graph[a].append(b)
        graph[b].append(a)


    return answer

def dfs(num):
    visited.add(num)
    for i in range(len(graph[num])):
        if graph[num][i] not in visited:
            dfs(graph[num][i])
    return


print(solution(9,[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]))