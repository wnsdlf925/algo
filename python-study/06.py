def solution(n, arr):

    arr.sort()

    end = 0
    nNum = 1
    answer = {}
    # for n in range(n):
    #     answer = {n+1}
    i = 0
    sum = 0
  
    while i < len(arr):

        
        if arr[i]>nNum :
            answer[nNum] = (sum)/(len(arr)-end)
            
            end = i
            nNum += 1
            sum = 0
            
            
            if nNum > n : break
           
        if i == len(arr)-1 :
            
            answer[nNum] = (sum)/(len(arr)-end)

        if arr[i]==nNum:
            sum += 1

        i +=1
    
    
    result = sorted(answer.items(), key=lambda x:(-x[1],x[0]))
    values_only = [item[0] for item in result]
    return values_only


# print(solution(5,[2,1,2,6,2,4,3,3]))
print(solution(4,[4,4,4,4,4]))