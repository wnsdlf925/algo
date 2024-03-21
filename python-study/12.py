def solution(prices):
    stack = list()
    answer = [0]*len(prices)

    for i in range(len(prices)):
        if stack:
            while stack and stack[-1][list(stack[-1].keys())[0]] > prices[i]:
                answer[list(stack[-1].keys())[0]] = i-list(stack[-1].keys())[0]
                stack.pop()
        stack.append({i:prices[i]})

    for i in range(len(prices)):
        if answer[i] == 0:
            answer[i] = len(prices)-1-i




    return answer

print(solution([5,1,2,3]))