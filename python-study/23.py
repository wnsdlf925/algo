def solution(record):

    dic = dict()
    sequence = list()
    index = 0
    answer = list()
    answerInStr = "님이 들어왔습니다."
    answerOutStr = "님이 나갔습니다."
    
    for i in record:
        temp = list(i.split())
        if temp[0][0] == "E":
            dic[temp[1]] = temp[2]
            sequence.append([])
            sequence[index].append(temp[1])
            sequence[index].append("E")
            index += 1
        elif temp[0][0] == "L":
            sequence.append([])
            sequence[index].append(temp[1])
            sequence[index].append("L")
            index += 1
        else: 
            dic[temp[1]] = temp[2]
            

    for i in sequence:

        if i[1] == "E":
            answer.append(dic[i[0]]+answerInStr)
        else:
            answer.append(dic[i[0]]+answerOutStr)
    
        


    return answer

print(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]))