def solution(s):
    alpabet = [0]*26
    answer = ""
    for i in s:
        alpabet[ord(i)-ord("a")] += 1
    
    for i, value in enumerate(alpabet):
        if value != 0:
            for j in range(value):
                answer += chr(i+ord("a"))
    
    return answer

print(solution("algorithm"))