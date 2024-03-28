from collections import deque

def solution(cards1,cards2,goal):

    cards1 = deque(cards1)
    cards2 = deque(cards2)
    goal = deque(goal)

    while goal:

        if cards1 and goal and cards1[0] == goal[0]:
            cards1.popleft()
            goal.popleft()
        elif cards2 and goal and cards2[0] == goal[0]:
            cards2.popleft()
            goal.popleft()
        else: break

    if not goal: return "Yes"
    else: return "No"
    

print(solution(["i", "water","drink"],["want","to"],["i","drink", "water","want","to"]))