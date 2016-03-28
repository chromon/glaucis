# -*- coding: utf-8 -*-

from email.mime.text import MIMEText
import smtplib

msg = MIMEText('Hello, a python mail...', 'plain', 'utf-8') 
msg2 = MIMEText('<html><body><h1>Hello</h1>' +
    '<p>send by <a href="http://www.python.org">Python</a>...</p>' +
    '</body></html>', 'html', 'utf-8')

from_addr = input('from:')
password = input('password:')
to_addr = input('to:')
smtp_server = input('smtp server:')

server = smtplib.SMTP(smtp_server, 25)
server.set_debuglevel(1)
server.login(from_addr, password)
server.sendmail(from_addr, [to_addr], msg.as_string())
server.quit()