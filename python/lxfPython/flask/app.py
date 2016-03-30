# -*- coding: utf-8 -*-

from flask import Flask
from flask import request

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def index() :
    return '''<h1>Home Page.</h1>
            <p><a href='/signin'>Sign In</a></p>'''

@app.route('/signin', methods=['GET'])
def signin_form() :
    return'''<form action='/signin' method='post'>
            <p><input type='text' name='username'/></p>
            <p><input type='password' name='password'/></p>
            <p><input type='submit' value='Sign In'/></p>
            </form>'''

@app.route('/signin', methods=['POST'])
def signin() :
    if request.form['username'] == 'ellery' and request.form['password'] == 'admin' :
        return '<h3>Hello, ellery</h3>'
    return '<h3>Bad username or password!</h3>'

if __name__ == '__main__' :
    app.run()