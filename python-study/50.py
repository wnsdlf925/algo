def solution(n):

    global answer

    answer = 0
    exist = [[False for _ in range(n)] for _ in range(n)]
    width = [False]*n
    rightTopBot = [False]*(2*n)
    leftTopBot = [False]*(2*n)

    def search(start,end):
        global answer
        if start >= end:
            answer += 1
            return

        for i in range(start,n):
            for j in range(n):
                if not exist[i][j] and not width[j] and not rightTopBot[i+j] and not leftTopBot[i-j+n]:
                    exist[i][j] = width[j] = rightTopBot[i+j]= leftTopBot[i-j+n] = True
                    search(i+1,end)
                    exist[i][j] = width[j] = rightTopBot[i+j]= leftTopBot[i-j+n] = False
            return

        return

    
    def checkX(i,j):

        check = False
        
        for z in range(n):
            tempI = i-z
            tempJ = j-z
            if tempI>=0 and tempJ>=0:
                if not exist[tempI][tempJ]:
                    check = True
                else: return False
            else: break
            
        for z in range(n):
            tempI = i-z
            tempJ = j+z
            if tempI>=0 and tempJ<n:
                if not exist[tempI][tempJ]:
                    check = True
                else: return False
            else: break
            
        return check


    search(0,n)


    return answer



print(solution(4))