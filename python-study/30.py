from collections import deque

def solution(maps):
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]
    que = deque()
    map = [list(i) for i in maps]
    visited = [[False for _ in range(len(i)) ] for i in maps]
    leber = list()
    end = list()
    answer = -1
    i_len = len(visited)
    j_len = len(visited[0])

    for i in range(len(map)):
        for j in range(len(map[i])):
            if map[i][j] == "S":
                que.append((i,j,0))
                visited[i][j] = True
            elif map[i][j] == "L":
                leber.append((i,j))
            elif map[i][j] == "E":
                end.append((i,j))

    while que:
        a,b,count = que.popleft()

        if map[a][b] == "L":
            que.clear()
            que.append((a,b,count))
            visited = [[False for _ in range(len(i)) ] for i in maps]
            visited[a][b] = True
            break
        elif map[a][b] != "X":
            for i in range(4):
                if move(a,b,dx[i],dy[i],i_len,j_len) and not visited[a+dy[i]][b+dx[i]]:
                    visited[a+dy[i]][b+dx[i]] = True
                    que.append((a+dy[i],b+dx[i],count+1))

    while que:
        a,b,count = que.popleft()

        if map[a][b] == "E":
            answer = count
            break
        elif map[a][b] != "X":
            for i in range(4):
                if move(a,b,dx[i],dy[i],i_len,j_len) and not visited[a+dy[i]][b+dx[i]]:
                    visited[a+dy[i]][b+dx[i]] = True
                    que.append((a+dy[i],b+dx[i],count+1))


    return answer

def move(i,j,dx,dy,ilen,jlen):

    return i+dy >= 0 and j+dx >= 0 and i+dy < ilen and j+dx < jlen 



print(solution(["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"]))