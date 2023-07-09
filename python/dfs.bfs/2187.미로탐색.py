from collections import deque

n, m = map(int, input().split())
board = [list(map(int, input().rstrip())) for _ in range(n)]
visited = [[0 for _ in range(m)] for _ in range(n)]

queue = deque()
queue.append((0,0))
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


while queue:
    x, y = queue.popleft()
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if 0<=nx<n and 0<=ny<m and board[nx][ny]==1:
            queue.append((nx,ny))
            board[nx][ny] = board[x][y] + 1
print(board[n-1][m-1])