import string 
import random
# user = open('user.txt', 'w')
# user.write(
#         '[\n'
#     )
# for i in range(3):
#     letters = string.ascii_letters
#     login = ( ''.join(random.choice(letters) for i in range(10)) )
#     password = ( ''.join(random.choice(letters) for i in range(15)) )
#     fname = ( ''.join(random.choice(letters) for i in range(10)) )
#     lname = ( ''.join(random.choice(letters) for i in range(10)) )
#     dig = string.digits
#     ss = random.randint(0,1)
#     sex = 'male'
#     if ss == 0:
#         sex = 'male'
#     else:
#         sex = 'female'
#     country = ( ''.join(random.choice(letters) for i in range(8)) )
#     city = ( ''.join(random.choice(letters) for i in range(7)) )
#     birthday = ( ''.join(random.choice(dig) for i in range(8)) )
#     day = ( ''.join(random.choice(dig) for i in range(8)) )
#     phone = '+' + ( ''.join(random.choice(dig) for i in range(7)) )
#     user.write( '{\n' + "\"id\": " + "\""+ str(i)+ "\",\n" + "\"login\": " + "\""+ login + "\",\n" + "\"password\": " + "\""+ password+ "\",\n" + "\"firstName\": " + "\"" + fname + "\",\n"   + "\"lastName\": " + "\"" + lname + "\",\n"  + "\"sex\": " + "\"" + sex + "\",\n"   
#     + "\"country\": " + "\"" + country + "\",\n" 
#     + "\"city\": " + "\"" + city + "\",\n"
#     + "\"birthDay\": " + "\"" + birthday + "\",\n"
#     + "\"date\": " + "\"" + day + "\",\n"
#     + "\"phone\": " + "\"" + phone + "\",\n"
#     + "\"status\": " + "\"" + "common" + "\"\n"
#     + '},\n')
# user.write(']')

# memef = open('meme.txt', 'w')
# memef.write(
#         '[\n'
#     )
# for i in range(100):
#     letters = string.ascii_letters
#     meme = ( ''.join(random.choice(letters) for i in range(10)) )
#     dig = string.digits
#     day = ( ''.join(random.choice(dig) for i in range(8)) )
#     memef.write( '{\n' + "\"id\": " + "\""+ str(i)+ "\",\n" + "\"link\": " + "\"" + meme + "\",\n"   + "\"date\": " + "\"" + day +"\"\n"+ '},\n')
# memef.write(']\n')


# memeReview = open('memeReview.txt', 'w')
# memeReview.write(
#         '[\n'
#     )
# for i in range(100):
#     letters = string.ascii_letters
#     userId = random.randint(0, 99)
#     memeId = random.randint(0, 99)
#     li = random.randint(0,1)
#     liked = "true"
#     if li == 0:
#         liked="false"
#     dig = string.digits
#     day = ( ''.join(random.choice(dig) for i in range(8)) )
#     memeReview.write( '{\n' + 
#     "\"id\": " + "\""+ str(i)+ "\",\n" 
#     + "\"userId\": " + "\"" + str(userId) + "\",\n"   
#     + "\"memeId\": " + "\"" + str(memeId) + "\",\n"
#     + "\"date\": " + "\"" + day +"\",\n"
#     + "\"liked\": " + "\"" + str(liked) +"\"\n"
#     + '},\n')
# memeReview.write(']\n')

userIntermation = open('userIntermation', 'w')
userIntermation.write(
        '[\n'
    )
for i in range(100):
    letters = string.ascii_letters
    source = random.randint(0, 99)
    target = random.randint(0, 99)
    li = random.randint(0,1)
    reaction = "right"
    if li == 0:
        reaction="left"
    dig = string.digits
    day = ( ''.join(random.choice(dig) for i in range(8)) )
    userIntermation.write( '{\n' + 
    "\"id\": " + "\""+ str(i)+ "\",\n" 
    + "\"source\": " + "\"" + str(source) + "\",\n"   
    + "\"target\": " + "\"" + str(target) + "\",\n"   
    + "\"reaction\": " + "\"" + reaction + "\",\n"
    + "\"date\": " + "\"" + day +"\"\n"
    + '},\n')
userIntermation.write(']\n')
