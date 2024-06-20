from heapq import heappop, heappush


def solution(land, height):
    answer = 0
    answerSum = 0
    length = len(land)
    visited = [[False for _ in range(length)] for _ in range(length)]
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    q = []

    heappush(q, (0, 0, 0, 0, 0, 0))
    stop = 0

    while q:

        cost, i, j, beforeI, beforeJ, check = heappop(q)
        if not visited[i][j]:
            visited[i][j] = True
            if check == 1:
                print(i, j, beforeI, beforeJ)
                answerSum += abs(land[i][j]-land[beforeI][beforeJ])

            for x in range(len(land)):
                print(visited[x])
            print(cost, i, j)

            for z in range(4):
                nx = j+dx[z]
                ny = i+dy[z]
                if nx >= 0 and nx < length and ny >= 0 and ny < length:
                    gap = abs(land[i][j]-land[ny][nx])
                    if not visited[ny][nx] and gap <= height:

                        heappush(q, (0, ny, nx, i, j, 0))
                    else:
                        heappush(q, (gap, ny, nx, i, j, 1))

    return answerSum


print(solution([[10, 11, 10, 11], [2, 21, 20, 10],
      [1, 20, 21, 11], [2, 1, 2, 1]], 1))
