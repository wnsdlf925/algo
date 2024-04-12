

def solution(k,operations):

    arr = [i for i in range(k)]


    for i in operations:
        

        if i[0] == "u":
            a, b = map(int, i[1:])
            union(arr, a, b)
        else:
            find(arr,i[1])
    
    print(arr)
    return find_answer(arr)

def union(arr, a,b):

    tempA = find(arr,a)
    tempB = find(arr,b)

    if tempA != tempB:
        if tempA < tempB:
            arr[tempA] = tempB
        else: arr[tempB] = tempA

    return

def find(arr, num):
    if arr[num] != num:
        arr[num] = find(arr,arr[num])
        return arr[num]
    else: return num

def find_answer(arr):
    rootNum = set()
    for i in range(len(arr)):
        if find(arr,i) not in rootNum:
            rootNum.add(find(arr,i))
            
            
            

    return  len(rootNum)





print(solution(3,[['u', 0, 1], ['u', 1, 2], ['f', 2]])) # 반환값 : 1
print(solution(4,[['u', 0, 1], ['u', 2, 3], ['f', 0]])) # 반환값 : 2