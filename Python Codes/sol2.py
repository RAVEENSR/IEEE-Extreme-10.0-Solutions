testCase = int(input())
for i in range(0,testCase):
    g = int(input())
    total = 0
    for j in range(0,g):
        number =  int(input())
        arr = [int(v) for v in input().split()]
        
        for k in arr:
            total+= k//2

    if(total%2 ==1):
        print('Alice')
    else:
        print('Bob')
