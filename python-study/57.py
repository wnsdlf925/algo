def solution(n):
    answer = ""
    
    sort = str(n)
    for i in sorted(sort, reverse=True):
        answer+=i
    
    

    return answer

print(solution(118372))