from flask import Flask, render_template, request
from antlr4.InputStream import InputStream
from testLexer import testLexer
from testParser import testParser
from antlr4.error.ErrorListener import ErrorListener
from testLexer import testLexer

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/upload', methods=['POST'])
def upload():
    content = ""
    if 'file' in request.files:
        file = request.files['file']
        if file.filename != '':
            content = file.read().decode('utf-8')
    return render_template('index.html', content=content)

@app.route('/limpiar')
def limpiar():
    return render_template('index.html')

if __name__ == '__main__':
    app.run(debug=True)
