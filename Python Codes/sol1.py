import math

def get1(n):
    if(n<4 or n%2!=0):
        return[0,0]
    li=get2(n)
    for c in range(2,(n/2)+1):
        if(li[c]==0):
            continue
        ne=n-c
        if(li[ne]):
            return [ne,c]

def get2(n):
    li=list(map(int,"1"*n))
    li[0]=0
    li[1]=0
    for i in range(2,n):
        if(li[i]==0):
            continue
    for j in range(2,n):
        if(i*j>=n):
            break
        else:
            li[i*j]=0
            return li

def isprime(num):
    if num < 2: return False
    elif num == 2: return True
    elif num % 2 == 0: return False
    else:
        check = 3
    while check <= math.sqrt(num):
        if num % check == 0:
            return False
        check += 2
    return True

def get3(n):
    i=int(n**0.5)
    while(True):
        if(n%2==1 and isprime(i)):
            return i
        i=i-1
        n=int(raw_input())
        k=get3(n)
        li=get1(n-k)
        print k,li[0],li[1]
