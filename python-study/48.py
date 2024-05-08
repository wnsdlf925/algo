
def solution(board):

    
    def check(i,j,count):
        for a in range(9):
            if count == board[i][a]:
                return False
        for a in range(9):
            if count == board[a][j]:
                return False
            
        boxI = (i//3)*3
        boxJ = (j//3)*3
        for newI in range(3):
            for newJ in range(3):
                if count == board[boxI+newI][boxJ+newJ]:
                    return False

        return True
    
    def zeroCheck():
        for i in range(9):
            for j in range(9):
                if board[i][j]==0:
                    return i,j
        return None

    
    def dfs():

        blank = zeroCheck()
        if not blank:
            return True
        # print(a,b)
        a,b = blank
        for count in range(9):
            if check(a,b,count+1):
                
                board[a][b] = count+1
                if dfs():
                    return True
                board[a][b] = 0
                

        return False
    
    
    dfs()
    return board

print(solution(
[
 [5, 3, 0, 0, 7, 0, 0, 0, 0],
 [6, 0, 0, 1, 9, 5, 0, 0, 0],
 [0, 9, 8, 0, 0, 0, 0, 6, 0],
 [8, 0, 0, 0, 6, 0, 0, 0, 3],
 [4, 0, 0, 8, 0, 3, 0, 0, 1],
 [7, 0, 0, 0, 2, 0, 0, 0, 6],
 [0, 6, 0, 0, 0, 0, 2, 8, 0],
 [0, 0, 0, 4, 1, 9, 0, 0, 5],
 [0, 0, 0, 0, 8, 0, 0, 7, 9],
])
)


