from collections import deque
N = int(input())
board = [list(input().rstrip()) for _ in range(N)]
visited = [[0]*N for _ in range(N)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(i, j):
    queue = deque()
    queue.append((i, j))
    color = board[i][j]
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0<=nx<N and 0<=ny<N and visited[nx][ny]==0:
                if board[nx][ny]==color:
                    visited[nx][ny] = 1
                    queue.append((nx, ny))
    return 1
a, b = 0, 0
for i in range(N):
    for j in range(N):
        if visited[i][j]==0:
            a+=bfs(i, j)

for i in range(N):
    for j in range(N):
        if board[i][j]=='G':
            board[i][j]='R'
visited = [[0]*N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if visited[i][j]==0:
            b+=bfs(i, j)

print(a, b)