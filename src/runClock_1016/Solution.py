a,b=map(int,raw_input().split(' '))
sum1=(b-a)/100.0
hour=int(sum1/3600)
sum1-=hour*3600
minute=int(sum1/60)
sum1-=minute*60
print "%02d:%02d:%02d"%(hour,minute,int(round(sum1)))