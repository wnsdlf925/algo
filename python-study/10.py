def solution(s):
    answer = 0
    temp = [s[i] for i in range(len(s))]
    
    for i in range(len(s)):
        if check(temp): answer += 1
        temp.insert(0,temp.pop())
        

    return answer

def check(s):

    stack = list()
    for i in range(len(s)):
        if len(stack) == 0:
            stack.append(s[i])
        else:
            if s[i] == "(":
                stack.append(s[i])
            elif s[i] == "{":
                stack.append(s[i])
            elif s[i] == "[":
                stack.append(s[i])
            elif s[i] == ")":
                if stack[-1] == "(":
                    stack.pop()
            elif s[i] == "}":
                if stack[-1] == "{":
                    stack.pop()
            elif s[i] == "]":
                if stack[-1] == "[":
                    stack.pop()
                

    if len(stack) == 0: return True
    else: return False
    

print(solution("]}(){["))