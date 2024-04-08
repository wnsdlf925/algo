from collections import deque

def solution(enroll, referral, seller, amount):
    
    tree = dict()
    cost = dict()
    answer = []
    tree["center"] = 0

    for i in range(len(enroll)):
        if referral[i] == "-":
            tree[enroll[i]] = "center"
        else:
            tree[enroll[i]] = referral[i]

        cost[enroll[i]] = 0

    
    
    for i in range(len(seller)):
        node = seller[i]
        nowAmount = amount[i]*100

        while tree[node] != 0:
            if nowAmount >= 10:
                cost[node] = cost[node] + nowAmount - (nowAmount // 10)
                nowAmount = nowAmount // 10
                node = tree[node]
            else:
                cost[node] += nowAmount
                break
            
    
    for i in enroll:
        answer.append(cost[i])
    
    return answer


print(solution(["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"],["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"],["young", "john", "tod", "emily", "mary"],[12, 4, 2, 5, 10]))

# zip(): 이터블한 객체를 동일한 인덱스에 위치한 노드를 묶어 튜플로 반환