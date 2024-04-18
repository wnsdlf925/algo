def solution(phone_book):
    answer = True
    same = list([set() for _ in range(20)])

    for i in phone_book:
        j = len(i)-1
        for z in range(j):
            same[z].add(i[0:z+1])
    for i in phone_book:

        j = len(i)-1
        if i in same[j]:
            answer = False
        else:
            same[j].add(i)
        if not answer:
            break
    
    return answer

print(solution(["119", "97674223", "1195524421"]))

# 문자열 비교함수 a.startswith("example")