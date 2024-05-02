from collections import deque
def solution(board):
    que = deque()
    dx = [1,0,-1,0]
    dy = [0,1,0,-1]
    n = len(board)
    
    answer = float("inf")
    

    visited = [[[0 for _ in range(4)] for _ in range(n)] for _ in range(n)]
    que.append((0,0,0,-1))

    while que:
        
        i,j,cost,direction = que.popleft()
        if i == n-1 and j == n-1:
            if cost < answer:
                answer = cost
        

        for z in range(4):
            nx = dx[z] + j
            ny = dy[z] + i
            if nx >= 0 and nx < n and ny >= 0 and ny < n and board[ny][nx] == 0:
                if i == n-1 and j == n-1:
                    if cost < answer:
                        answer = cost
                else:
                    new_cost = 0
                    if direction == -1 or (direction+z)%2 == 0:
                            new_cost = cost + 100
                    else:
                            new_cost = cost + 600

                    if visited[nx][ny][z] == 0 or visited[nx][ny][z] > new_cost:
                        visited[nx][ny][z] = new_cost
                        que.append((ny,nx,new_cost,z))
                            
                        
                    


    return answer

print(solution([[0, 0, 0, 0, 0], [0, 1, 1, 1, 0], [0, 0, 1, 0, 0], [1, 0, 0, 0, 1], [0, 1, 1, 0, 0]] ))
# print(solution([[0,0,0],[0,0,0],[0,0,0]]))
# print(solution(	[[0, 0, 0, 0, 0, 0, 0, 1], [0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 1, 0, 0], [0, 0, 0, 0, 1, 0, 0, 0], [0, 0, 0, 1, 0, 0, 0, 1], [0, 0, 1, 0, 0, 0, 1, 0], [0, 1, 0, 0, 0, 1, 0, 0], [1, 0, 0, 0, 0, 0, 0, 0]]))
# print(solution(	[[0, 0, 1, 0], [0, 0, 0, 0], [0, 1, 0, 1], [1, 0, 0, 0]]))
# print(solution([[0, 0, 0, 0, 0, 0], [0, 1, 1, 1, 1, 0], [0, 0, 1, 0, 0, 0], [1, 0, 0, 1, 0, 1], [0, 1, 0, 0, 0, 1], [0, 0, 0, 0, 0, 0]]))