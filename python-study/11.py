def solution(s):

    n = len(s)
    stack = list()

    for i in range(n):
        if stack: print("111")
        else:  
            stack.append("222") 
            print("222")
        
        # if len(stack) == 0:
        #     stack.append(s[i])
        # else:
        #     if stack[-1] == s[i]:
        #         stack.pop()

    if len(stack) == 0: return 1
    else: return 0 

    


print(solution("cdcd"))