

def solution(arr):
    answer = list()

    for i in range(len(arr)):
        for j in range(len(arr)):
            if i!=j:
                answer.append(arr[i]+arr[j])
    
    answer = sorted(set(answer))

    return answer


print(solution([2,1,3,4,1])) 
print(solution([5,0,2,7])) 