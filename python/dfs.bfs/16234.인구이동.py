from collections import deque
N, L, R = map(int, input().split())
space = [list(map(int, input().split())) for _ in range(N)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
# visited = [[0]*N for _ in range(N)]
def bfs(i, j):
    queue = deque()
    queue.append((i, j))
    temp = []
    visited[i][j]=1
    temp.append((i, j))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0<=nx<N and 0<=ny<N and visited[nx][ny]==0:
                if L<=abs(space[nx][ny]-space[x][y])<=R:
                    visited[nx][ny]=1
                    queue.append((nx,ny))
                    temp.append((nx, ny))
    return temp
cnt = 0

while 1:
    visited = [[0]*N for _ in range(N)]
    check = False
    for i in range(N):
        for j in range(N):
            if visited[i][j]==0:
                temp = bfs(i,j)
                if len(temp)>1:
                    check = True
                    sum = 0
                    for t in temp:
                        sum += space[t[0]][t[1]]
                    for t in temp:
                        space[t[0]][t[1]] = sum//len(temp)   
    if not check:
        print(cnt)
        break
    cnt+=1           