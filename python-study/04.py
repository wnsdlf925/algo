

person = [[1,2,3,4,5],[2,1,2,3,2,4,2,5],[3,3,1,1,2,2,4,4,5,5]]
answer = list()


def solution (arr):

    for i in range(len(person)):
        answer.append(0)
        for j in range(len(arr)):
            if person[i][j%len(person[i])] == arr[j]:
                answer[i] += 1 

    maxNum = max(answer)
    answerArr = list()

    for i in range(len(answer)):
        if answer[i] == maxNum:
            answerArr.append(i+1)

    return answerArr



print(solution([1,3,2,4,2])) 


# >>> for i, letter in enumerate(['A', 'B', 'C'], start=1):
# ...     print(i, letter)
# ...
# 1 A
# 2 B
# 3 C
# enumerate 인덱스와 값을 넘겨줌

