from collections import deque

def solution(maps):
    iLen = len(maps)
    jLen = len(maps[0])
    move = [[0,1],[0,-1],[1,0],[-1,0]]
    answer = -1

    visited = set()
    visited.add((0,0))
    que = deque()
    que.append((0,0,1))

    while que:
        i, j, route = que.popleft()

        if i == iLen-1 and j == jLen-1:
            answer = route
            break

        for x,y in move:
            tempI = i+y
            tempJ = j+x
            if tempI >= 0 and tempI < iLen and tempJ >= 0 and tempJ < jLen and maps[tempI][tempJ]==1 and (tempI, tempJ)not in visited:
                que.append((tempI,tempJ,route+1))
                visited.add((tempI,tempJ))

    return answer

print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))