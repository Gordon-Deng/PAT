num = input()

def calc(num):
    if len(set(num)) == 1:
        print(num + " - " + num + " = 0000")
        return "6174"
    else:
        num1 = "".join(sorted(num, reverse=True))
        num2 = "".join(sorted(num))
        result = str(int(num1) - int(num2))
        print(num1 + " - " + num2 + " = " + result)
        return result

num=calc(num.ljust(4,"0"))
while num != "6174":
    num = calc(num.ljust(4,"0"))