# -*- coding: utf-8 -*-

from flask import Flask, request, render_template

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def index() :
    return render_template('index.html')

@app.route('/signin', methods=['GET'])
def signin_form() :
    return render_template('form.html')

@app.route('/signin', methods=['POST'])
def signin() :
    username = request.form['username']
    password = request.form['password']
    if username == 'ellery' and password == 'admin' :
        return render_template('success.html', username=username)
    return render_template('form.html', message='Bad username or password', username=username)

if __name__ == '__main__' :
    app.run()