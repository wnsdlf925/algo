from collections import *
def solution(graphs, start):
    answer = []
    graph = defaultdict(list)
    que = deque()
    visited = set()

    for a, b in graphs:
        print(a,b)
        graph[a].append(b)

    que.append(start)
    visited.add(start)

    while que:

        node = que.popleft()
        answer.append(node)

        for i in graph[node]:
            if i not in visited:
                que.append(i)
                visited.add(i)


    return answer



print(solution([(1, 2), (1, 3), (2, 4), (2, 5), (3, 6), (3, 7), (4, 8), (5, 8), (6, 9), (7, 9)],1)) # 반환값 :[1, 2, 3, 4, 5, 6, 7, 8, 9]
# print(solution([(0, 1), (1, 2), (2, 3), (3, 4), (4, 5), (5, 0)],1)) # 반환값 : [1, 2, 3, 4, 5, 0]