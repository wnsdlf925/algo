def solution(participant,completion):


    com = dict()
    for i in completion:
        if i in com:
            com[i] = com[i]+1
        else: com[i] = 1

    print(com)
    for i in participant:
        if i in com:
            if com[i] > 0:
                com[i] = com[i]-1
            else: return i
        else: return i 

    return
print(solution(["mislav", "stanko", "mislav", "ana"],["stanko", "ana", "mislav"]	))