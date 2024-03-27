from collections import deque

def solution(n,k):
    answer = deque(i for i in range(n))
    count = 1
    
    while len(answer)>1:
        if count != k:
            temp = answer.popleft()
            answer.append(temp)
            count += 1
        else: 
            answer.popleft()
            count = 1

    return answer[0]+1


print(solution(5,2))