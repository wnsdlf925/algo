from collections import deque
import math
def solution(progresses,speeds):

    answer = list()
    que = deque(progresses)
    speed = deque(speeds)
    day = 0
    count = 0 

    while que:
        nowSpeed = speed[0]
        now = que[0] + (day*nowSpeed)
        if now < 100:
            if count != 0:
                answer.append(count)
                count = 0
            day += math.ceil((100-now)/nowSpeed)
        else: 
            que.popleft()
            speed.popleft()
            count += 1

    answer.append(count)


    return answer

print(solution([93,30,55],[1,30,5]))