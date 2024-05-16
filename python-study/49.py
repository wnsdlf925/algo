from itertools import permutations
def solution(k, dungeons):
    answer = -1

    for permutation in permutations(dungeons,len(dungeons)):
        temp = k
        count = 0
        for i in permutation:
            if temp >= i[0]:
                temp -= i[1]
                count += 1
        if count > answer:
            answer = count

    return answer

print(solution(80,[[80,20],[50,40],[30,10]]))