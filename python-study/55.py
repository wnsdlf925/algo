def solution(arr1,arr2):

    arr1Idx = 0
    arr2Idx = 0
    answer = []

    while arr1Idx < len(arr1) and arr2Idx < len(arr2):
        if arr1[arr1Idx] < arr2[arr2Idx]:
            answer.append(arr1[arr1Idx])
            arr1Idx+=1
        else:
            answer.append(arr2[arr2Idx])
            arr2Idx+=1
        
    while arr1Idx < len(arr1):
        answer.append(arr1[arr1Idx])
        arr1Idx+=1
    while arr2Idx < len(arr2):
        answer.append(arr2[arr2Idx])
        arr2Idx+=1
        
    return answer

print(solution([1, 3, 5], [2, 4, 6])) # 반환값 : [1, 2, 3, 4, 5, 6]
print(solution([1, 2, 3], [4, 5, 6])) # 반환값 : [1, 2, 3, 4, 5, 6]