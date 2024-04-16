def solution(n, words):
    
    answer = [0,0]
    word = set()
    count = 1
    round = 1
    for i, w in enumerate(words):
        print(i, w)

    for i in range(len(words)):
        if words[i] in word:
            answer[0] = count
            answer[1] = round
            break
        word.add(words[i])

        if i > 0:
            if words[i-1][-1] != words[i][0]:
                answer[0] = count
                answer[1] = round
                break
        
        count += 1
        if count > n:
            count = 1
            round += 1
    

    return answer

print(solution(2,["hello", "one", "even", "never", "now", "world", "draw"]))