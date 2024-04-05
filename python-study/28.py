def solution(n,a,b):


    answer = 0
    start = 0
    end = n
    count = 0
    
    while True:

        length = (start+end)//2
        print(length)
        if a > length and b > length:
            count += 1
            start = length
        elif a <= length and b <= length:
            count += 1
            end = length
        else: break

    cartien = 1
    for i in range(count):
        cartien *= 2

    while cartien != n:
        cartien *= 2
        answer += 1
    
    return answer

print(solution(16,5,6))