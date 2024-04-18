def solution(n, costs):

    answer = 0

    cost = sorted(list(costs), key=lambda x: x[2])
    group = [i for i in range(n)]
    
    for i in cost:
        if not union(group,i[0],i[1]):
            answer += i[2]

    return answer


def find(arr, num):

    if arr[num] != num:
        arr[num] = find(arr,arr[num])
        return arr[num]
    
    else: return num
    

def union(arr, a, b):
    parentA = find(arr,a)
    parentB = find(arr,b)
    if parentA == parentB: return True

    else: 
        if parentA > parentB:
            arr[parentA] = parentB
        else:
            arr[parentB] = parentA

        return False






print(solution(4,[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]))