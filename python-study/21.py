def solution(want, number, discount):

    dic = dict()
    dis = dict()
    n = len(number)
    nCount = 0
    count = 0
    day = 0

    for i in range(len(want)):
        dic[want[i]] = 0
        dis[want[i]] = number[i]

    for i in range(len(discount)):
        if nCount < 10:
            if discount[i] in dic:
                dic[discount[i]] += 1
                
        else:
            if discount[i] in dic:
                dic[discount[i]] += 1

            if discount[i-10] in dic:
                dic[discount[i-10]] -= 1
        
        if dic == dis: day += 1


    
        nCount += 1

        


    return day

print(solution(["banana", "apple", "rice", "pork", "pot"],[3, 2, 2, 2, 1],["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]))