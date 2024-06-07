def solution(s):
    arr = s[2:-2].split("},{")
    arr = sorted(arr, key=len)

    answer = []
    for i in arr:
        i = i.split(",")
        for j in i:
            if int(j) not in answer:
                answer.append(int(j))
    print(arr)
    return answer


print(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))
