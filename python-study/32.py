from collections import deque

def solution(nodeinfo):
    node = {}
    que = deque()

    for i in range(len(nodeinfo)):
        if nodeinfo[i][1] not in node:
            node[nodeinfo[i][1]] = []
            node[nodeinfo[i][1]].append((nodeinfo[i][0],i+1))
        else:
            node[nodeinfo[i][1]].append((nodeinfo[i][0],i+1))

    for i in node:
        node[i] = sorted(node[i], key= lambda x : x[0])

    height = max(node)
    que.append(node[height])

    while que:
        nowNode = que.appendleft
        height = nowNode
        print(nowNode)
        que.popleft()
        # for i in range(height-1,-1,-1):
        
    
    answer = [[]]
    return answer

print(solution([[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]))



