def solution(dirs):

    answer = set()
    i = 0
    j = 0

    for dir in range(len(dirs)):
        if dirs[dir] == "U":
            if check(i+1,j):
                answer.add((i,j,i+1,j))
                answer.add((i+1,j,i,j))
                i += 1
                
            
        elif dirs[dir] == "D":
            if check(i-1,j):
                answer.add((i,j,i-1,j))
                answer.add((i-1,j,i,j))
                i -= 1
                
        elif dirs[dir] == "R":
            if check(i,j+1):
                answer.add((i,j,i,j+1))
                answer.add((i,j+1,i,j))
                j += 1
                
        elif dirs[dir] == "L":
            if check(i,j-1):
                answer.add((i,j,i,j-1))
                answer.add((i,j-1,i,j))
                j -= 1
                
    
    return int(len(answer)/2)


def check(i,j):

    if abs(i)<6 and abs(j)<6: return True
    else: return False
    
    



print(solution("ULURRDLLU"))
print(solution("LULLLLLLU"))