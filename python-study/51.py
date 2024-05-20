def solution(n, info):
    global answer
    answer = [0]*11
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
        if temp[0]==1 and temp[1]==1 and temp[2]==1 and temp[3]==1 and temp[4]==1 and temp[5]==1 :
                        print(temp)
        if arrow == 0:
            
            nowScore = score(temp)

            if nowScore > 0 and nowScore >= maxNum:
                maxNum = nowScore
                for i, value in enumerate(temp):
                    answer[i] = value
                
                return
            else: return
        
        
        for i in range(index,11):
            if info[i] >= temp[i]:
                if arrow-info[i]+1 >= 0:
                    
                    temp[i] = info[i]+1
                    find(arrow-temp[i],i+1)
                    temp[i] = 0 
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
    for i in answer:
        if i != 0:
            return answer
    return [-1]


print(solution(10,	[0,0,0,0,0,0,0,0,3,4,3]))