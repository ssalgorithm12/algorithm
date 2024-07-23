T = int(input())
x = [31,28,31,30,31,30,31,31,30,31,30,31]
for t in range(1, T + 1):
    a = input()
    m = int(a[4:6])
    r = -1
    if 0<m<=12 and x[m-1]>=int(a[6:])>0:
        r = a[0:4]+"/"+a[4:6]+"/"+a[6:]
    print(f"#{t} {r}")
