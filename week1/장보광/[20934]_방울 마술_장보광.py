T = int(input())
for t in range(1, T+1):
    s,n = input().split()
    r = 0
    if s=="..o" and n == '0': r = 2;
    elif s==".o.":
        if int(n)&1==0 : r = 1;
    else:
        if int(n)&1==1 : r = 1;
    print(f"#{t} {r}")
