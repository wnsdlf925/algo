tree = []
def solution(lst,search_lst):
    global tree
    tree = [0]*(40)
    answer = []

    for i in range(1, len(lst)+1):
        if i == 1: tree[i] = lst[i-1]
        else:
            index = 1
            
            while tree[index] != 0:
                if tree[index] > lst[i-1]:
                    index *= 2
                else: index = (index*2)+1
            tree[index] = lst[i-1]
    print(tree)
    for i in search_lst:
        if find(i): answer.append(True)
        else: answer.append(False)


    return answer

def find(num):
    global tree
    index = 1
    print(num,"num")
    while tree[index] != num:
        print(index)
        if tree[index] > num:
            index *= 2
        elif tree[index] < num:
            index = (index*2)+1
        elif tree[index] == 0:
            return False
        
        
        if index > len(tree):
            return False
        
    return True
    


print(solution([5, 3, 8, 4, 2, 1, 7, 10], [1, 2, 5, 6])) # [True, True, True, False]
print(solution([1, 3, 5, 7, 9], [2, 4, 6, 8, 10])) # [False, False, False, False, False] 