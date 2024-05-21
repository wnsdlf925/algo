def solution(n, info):
    global answer
    answer = [list()]
    global maxNum
    maxNum = 0
    global apeachScore
    apeachScore = 0
    global temp
    temp = [0]*11
    global stop
    stop = False
    global test
    test = 0
    
    for i, value in enumerate(info):
        if value != 0:
            apeachScore += (10-i) 

    
    def find(arrow,index):
        global stop, maxNum, temp, test
        
        if arrow == 0:
            
            nowScore = score(temp)

            if nowScore > 0:
                    if nowScore > maxNum:
                        maxNum = nowScore
                        answer.clear()
                        answerArr = [0]*11
                        for i, value in enumerate(temp):
                            answerArr[i] = value
                        answer.append(answerArr)
                        return
                    elif nowScore == maxNum:
                        
                        answerArr = [0]*11
                        for i, value in enumerate(temp):
                            answerArr[i] = value
                        answer.append(answerArr)
                        return
            else: return
        
        
        for i in range(index,11):
         
            if info[i] >= temp[i]:
                temp[i] += 1
                find(arrow-1,i)
                temp[i] -= 1 
            else: find(arrow,i+1)
            

        return
    
    def score(arr):
        apearch = 0
        lion = 0
        for i, value in enumerate(arr):
            if arr[i] > info[i]:
                lion += (10-i)
            else :
                if info[i] != 0: 
                    apearch += (10-i)
        return lion - apearch
    
    find(n,0)
    answer = sorted(answer,  key=lambda x: x[::-1], reverse=True)
    
    for i in answer[0]:
        if i != 0:
            return answer[0]
    return [-1]


print(solution(10,	[0,0,0,0,0,0,0,0,3,4,3]))