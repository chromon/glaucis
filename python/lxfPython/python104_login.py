# -*- coding: utf-8 -*-

import hashlib

db = {}

def register(username, password):
    if not username in db :
        db[username] = calc_md5(password + username + 'the-Salt')
        print('register success!')
    else :
        print('username already exits!')

def calc_md5(password):
    md5 = hashlib.md5()
    md5.update(password.encode('utf-8'))
    return md5.hexdigest()

def login(username, password):
    if not username in db :
        print('username not exits!')
    else :
        if db[username] == calc_md5(password + username + 'the-Salt') :
            print('login success!')
        else :
            print('username or password incorrect!')

register('ellery', 'hellopython')
login('ellery', 'hellopython')
