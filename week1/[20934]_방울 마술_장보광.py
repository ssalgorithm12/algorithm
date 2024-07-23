T = int(input())
for t in range(1, T+1):
    s = input().split()
    a= [i for i in range(3) if s[0][i]=='o'][0]
    n = int(s[1])
    r = 0
    if a==2 and n == 0: r = 2;
    elif a==1 and n&1==0 : r = 1;
    elif a!=1 and n&1==1 : r = 1;
    print(f"#{t} {r}")
