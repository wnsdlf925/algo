from itertools import *
from collections import *

def solution(orders, course):

    answer = []
    

    for i in course:
        set_menu = dict()
        for j in orders:
            for z in combinations(sorted(j),i):
                temp = ""
                for x in range(len(z)):
                    temp += z[x]
                if temp in set_menu:
                    set_menu[temp] += 1
                else: set_menu[temp] = 1
        
        for j in set_menu:
            if set_menu[j] > 1 and set_menu[j] == max(set_menu.values()):
                answer.append(j)
        

  
    return sorted(answer)

print(solution(["XYZ", "XWY", "WXA"], [2, 3, 4]))

#조합 combinations
#순열 purpumtation
# 
# 
# 
# 
# 
# 
