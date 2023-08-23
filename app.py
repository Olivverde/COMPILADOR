from flask import *
import subprocess
from antlr4.InputStream import InputStream
from testLexer import testLexer
from testParser import testParser
from antlr4.error.ErrorListener import ErrorListener
from testLexer import testLexer
from Main import *

app = Flask(__name__)

def antlrParse(data):
    input_code = data  # Esto lee el contenido desde la consola
    input_stream = InputStream(input_code)
    print('este es el input1', input_code)
    print('\neste es el input', input_stream)
    lexer = testLexer(input_stream)
    lexer.removeErrorListeners()
    token_stream = CommonTokenStream(lexer)
    parser = testParser(token_stream)
    myError = errorListener() 
    parser.removeErrorListeners()
    parser.addErrorListener(myError)
    tree = parser.program()  

    if myError.getHasError():
        print(Style.BRIGHT + "Se ha(n) encontrado error(es)" + Style.RESET_ALL)
        for i in myError.listErrors:
            print(i)
    else:
        printer = ShowTable()
        visitor = TransformDot()
        visitor.visit(tree)
        dot = visitor.getDot()
        walkerTree = ParseTreeWalker() # recorrer este árbol de análisis y aplicar logica
        walkerTree.walk(printer, tree)
        with open('ast.dot', 'w') as file:
            file.write(dot)
        print(Fore.GREEN +'Árbol generado con éxito, visualize: ' + Style.BRIGHT + "out.png" + Style.RESET_ALL)
    return myError

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

@app.route('/compile', methods=['POST'])
def compile_code():
    content = request.json.get('code', '')  # Obtener el contenido del código del campo JSON
    print('\ncontent', content)
    print('-----------------------------------------\n')
    cmd = ['python', 'Main.py']  # Comando para ejecutar el compilador
    process = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True, stdin=subprocess.PIPE)
    stdout= antlrParse(content)  # Pasar el contenido del código como entrada estándar
    print('\n\nstdout', stdout)

    output=""
    if stdout.getHasError():
                print(Style.BRIGHT + "Se ha(n) encontrado error(es)" + Style.RESET_ALL)
                output="Se ha(n) encontrado error(es)"
                for i in stdout.listErrors:
                    output=output+"\n"+i
                    print(i)


    return json.dumps({'result': "Compilo", 'output': output})


if __name__ == '__main__':
    app.run(debug=True)
