while 1:
    try:
        root,n,rn = raw_input().split()
        result,tmp,n,i = [],{},int(n),0
        while n:
            node = raw_input().split()
            tmp[node[0]] = [node[1],node[2]]
            n -= 1
        while root != '-1':
            result.append((root,tmp[root][0]))
            root = tmp[root][1]
        while len(result) - i >= int(rn):
            result[i:i+int(rn)] = result[i:i+int(rn)][::-1]
            i += int(rn)
        else:
            for index in range(len(result)):
                if index == len(result) - 1:
                    print result[index][0],result[index][1],-1
                else:
                    print result[index][0],result[index][1],result[index+1][0]
    except:
        break