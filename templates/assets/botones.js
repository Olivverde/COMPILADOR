//Cargar un archivo en entrada
function abrir(){
    const fileInput = document.getElementById('file-input');
    fileInput.onchange = function(e) {
        const file = fileInput.files[0];
        const reader = new FileReader();

        reader.onload = function(e) {
            const content = e.target.result;
            document.getElementById('input').value = content;
        };

        reader.readAsText(file);
    };

    fileInput.click();
}

//Borrar el código que está en el apartado de entrada
function limpiar(){
    location.reload()
}


//Para que salgan las líneas en la entrada
const lineNumberContainer = document.querySelector('.line-number');
const textarea = document.getElementById('input');

textarea.addEventListener('input', updateLineNumbers);
textarea.addEventListener('scroll', syncScroll);

function updateLineNumbers() {
  const lines = textarea.value.split('\n');
  const lineNumbers = lines.map((_, index) => index + 1);
  lineNumberContainer.innerHTML = lineNumbers.join('<br>');
}

function syncScroll() {
  lineNumberContainer.style.marginTop = `-${textarea.scrollTop}px`;
}

updateLineNumbers();



