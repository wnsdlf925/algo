def solution(decimal):

    stack = list()

    while decimal > 1:
        stack.append(str(decimal%2))
        decimal //= 2

    stack.append(str(decimal%2))

    answer = ""
    for i in range(len(stack)):
        answer += answer.join(stack.pop())

    return answer

print(solution(10))