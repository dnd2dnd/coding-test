from collections import deque

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

x, y, size = 0, 0, 2
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

for i in range(n):
    for j in range(n):
        if board[i][j] == 9:
            x, y = i, j

def biteFish(x, y, shark_size):
    distance = [[0]* n for _ in range(n)]
    visited = [[0]* n for _ in range(n)]

    q = deque()
    q.append((x, y))
    visited[x][y] = 1
    temp = []
    while q:
        cur_x, cur_y = q.popleft()
        for i in range(4):
            nx = cur_x + dx[i]
            ny = cur_y + dy[i]
            if 0<=nx<n and 0<=ny<n and visited[nx][ny]==0:
                if board[nx][ny] <= shark_size:
                    q.append((nx, ny))
                    visited[nx][ny] = 1
                    distance[nx][ny] = distance[cur_x][cur_y] + 1
                    if board[nx][ny] < shark_size and board[nx][ny] != 0:
                        temp.append((nx, ny, distance[nx][ny]))
    return sorted(temp, key=lambda x: (x[2], x[0], [1]))

print(biteFish(x,y,size).pop())

