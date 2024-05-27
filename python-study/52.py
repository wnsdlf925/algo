from itertools import permutations
def solution(n,weak,dist):

    answer = len(dist)+1

    length = len(weak)
    for i in range(length):
        weak.append(weak[i]+n)

    for i in range(length):
        for friends in permutations(dist, len(dist)):
            cnt = 1
            position = weak[i] + friends[cnt -1]
            print(friends)
            for j in range(i, i+length):
                if position < weak[j]:
                    cnt+=1
                    if cnt>len(dist):
                        break
                    position = weak[j] + friends[cnt -1]
                
            answer = min(answer,cnt)

    return answer

print(solution(12,[1, 5, 6, 10],[1, 2, 3, 4]))