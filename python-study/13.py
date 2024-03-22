def solution(board, moves):
    
    boardStack = []
    bucket = list()
    n = len(board)
    answer = 0

    for i in range(n):
        boardStack.append(list())

    for j in range(n):
        for i in range(n-1,-1,-1):
            if board[i][j] != 0: boardStack[j].append(board[i][j])
            

    for i in range(len(moves)):

        if bucket and check(boardStack[moves[i]-1]):
            if bucket[-1] == boardStack[moves[i]-1][-1]:
                bucket.pop()
                boardStack[moves[i]-1].pop()
                answer += 1
            else: bucket.append(boardStack[moves[i]-1].pop())

        if not bucket and check(boardStack[moves[i]-1]): bucket.append(boardStack[moves[i]-1].pop())

    return answer*2

def check(arr):
    if len(arr) != 0: return True
    else: return False


print(solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]],[1,5,3,5,1,2,1,4]))