arr=list(map(int,input().split()))
res=""
if arr[0]!=0:
    for i,v in enumerate(arr):
        if v!=0 and i!=0:
            arr[i]-=1
            res+=str(i)
            break
for i,v in enumerate(arr):
    res+=str(i)*v
print(res)