

def solution(board, aloc, bloc):
    # 1
    ROW, COL = len(board),len(board[0])
    # 2
    DR, DC = [-1,0,1,0],[0,1,0,-1]
    # 3
    def is_valid_pos(r,c):
        return 0 <= r < ROW and 0 <= c < COL
    # 4
    def recur(a_pos,b_pos,visited,step):
        # 5
        r,c = a_pos if step% 2 == 0 else b_pos
        can_move = False
        is_opponent_winner = True
        # 6
        win_steps,lose_steps = [],[]
        # 7
        for i in range(4):
            nr, nc = r+DR[i], c+DC[i]
            # 8
            if is_valid_pos(nr,nc) and (nr,nc) not in visited and board[nr][nc]:
                can_move = True
                # 9
                if a_pos == b_pos:
                    return True, step+1
                # 10
                win, steps_left = (
                    recur([nr,nc],b_pos, visited | {(r,c)},step+1)
                    if step % 2 == 0
                    else recur(
                        a_pos,[nr,nc], visited | {(r,c)},step+1
                        )
                        )
                # 11
                is_opponent_winner &= win
                # 12
                (win_steps if win else lose_steps).append(steps_left)
        # 13
        if not can_move:
            return False,step
        # 14
        if is_opponent_winner:
            return False, max(win_steps)
        # 15
        return True,min(lose_steps)
    # 16
    _,steps = recur(aloc,bloc,set(),0)
    return steps


print(solution([[1, 1, 1], [1, 1, 1], [1, 1, 1]],[1, 0],[1, 2]))