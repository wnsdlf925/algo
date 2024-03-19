def solution(s):

    stack = list()
    for i in range(len(s)):
        if len(stack)==0:
            stack.append(s[i])
        else:
            if s[i] == "(":
                stack.append(s[i])
            else:
                if stack[-1] == "(":
                    stack.pop()

    if len(stack) == 0: return True
    else : return False

    



print(solution("((())()"))