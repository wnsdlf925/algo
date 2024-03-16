
def solution(arr1, arr2):

    answer = [[0]*len(arr2[0]) for _ in range(len(arr1))]
# answer = [[0]*len(arr2[0]) for _ in range(len(arr1))] 앞부분이 j 뒤가 i

    for i in range(len(arr1)):
        
        for j in range(len(arr2[0])):
            sum = 0
            for z in range(len(arr1[0])):
                sum += arr1[i][z]*arr2[z][j]
            answer[i][j] = sum


    return answer




print(solution([[1,4],[3,2],[4,1]],[[3,3],[3,3]])) 