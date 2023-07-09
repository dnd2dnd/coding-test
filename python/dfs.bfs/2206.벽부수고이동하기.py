from collections import deque
import sys

N, M = map(int, sys.stdin.readline().split())
board = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(N)]
visited = [[[0 for col in range(2)] for row in range(M)] for depth in range(N)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

queue = deque()
queue.append((0, 0, 1, 0))

arrive = False
while queue:
    x, y, d, c = queue.popleft()

    if x==N-1 and y==M-1:
        arrive = True
        print(d)
        break

    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if 0<=nx<N and 0<=ny<M:
            if board[nx][ny]==1:
                if visited[nx][ny][1]==0 and c==0:
                    queue.append((nx, ny, d+1, 1))
                    visited[nx][ny][1] = 1
            elif board[nx][ny]==0 :
                if visited[nx][ny][0]==0 and c==0:
                    queue.append((nx, ny, d+1, 0))
                    visited[nx][ny][0] = 1
                if visited[nx][ny][1]==0 and c==1:
                    queue.append((nx, ny, d+1, 1))
                    visited[nx][ny][1] = 1                            

if not arrive: 
    print(-1)
