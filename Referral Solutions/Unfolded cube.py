#Your code below
n=6
m=(list(map(str,input().split())))
c=int(input())
for j in range(c):
for k in range(c*4):
if k>=c and k<c+c:
print(m[5],end=" ")
else:
print("*",end=" ")
print()
for j in range(c):
for k in range(c*4):
if k<c*1:
print(m[3],end=" ")
elif k<c*2:
print(m[0],end=" ")
elif k<c*3:
print(m[1],end=" ")
elif k<c*4:
print(m[2],end=" ")
print()
for j in range(c):
if k in range(c*4):
if k>=c and k<c+c:
print(m[4],end=" ")
else:
print("*",end=" ")