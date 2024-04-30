
def solution(n, computers):
    global visited
    visited = set()
    answer = 0
    
    for i in range(n):
        if i not in visited:
            visited.add(i)
            dfs(i,computers)
            answer+=1

    
    return answer

def dfs(num,computers):
    for i, connect in enumerate(computers[num]):
        if i not in visited and connect == 1:
            visited.add(i)
            dfs(i,computers)
    return


print(solution(3,[[1, 1, 0], [1, 1, 0], [0, 0, 1]]))
print(solution(3,[[1, 1, 0], [1, 1, 1], [0, 1, 1]]))