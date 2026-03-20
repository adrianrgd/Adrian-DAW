// Esperamos a que cargue todo el html para empezar a hacer cosas
document.addEventListener('DOMContentLoaded', () => {
    cargarTarjetas();
    document.getElementById('buscador').addEventListener('input', filtrarTarjetas);
    document.getElementById('selectorTema').addEventListener('change', aplicarTemaElegido);
    document.getElementById('btnPaleta').addEventListener('click', abrirPanelColores);
    prepararBotonesModal();
    document.getElementById('formularioAñadir').addEventListener('submit', guardarNuevaTarjeta);
});

// Funcion para leer el archivo xml y sacar los trenes
function cargarTarjetas() {
    fetch('data/tarjetas.xml')
        .then(respuesta => respuesta.text())
        .then(textoXML => {
            const parser = new DOMParser();
            const xml = parser.parseFromString(textoXML, "text/xml");
            const tarjetas = xml.querySelectorAll('tarjeta');
            
            for (let i = 0; i < tarjetas.length; i++) {
                const titulo = tarjetas[i].querySelector('titulo').textContent;
                const imagen = tarjetas[i].querySelector('imagen').textContent.trim();
                const año = tarjetas[i].querySelector('año').textContent;
                const fabricante = tarjetas[i].querySelector('fabricante').textContent;
                const composicion = tarjetas[i].querySelector('composicion').textContent;
                const texto = tarjetas[i].querySelector('texto').textContent;
                
                crearElementoTarjeta(titulo, imagen, año, fabricante, composicion, texto);
            }
        });
}

// Creamos la caja en el html para que se vea el tren
function crearElementoTarjeta(titulo, imagen, año, fabricante, composicion, texto) {
    const contenedor = document.getElementById('contenedorTarjetas');
    const caja = document.createElement('div');
    caja.className = 'tarjeta';
    caja.innerHTML = `
        <img src="${imagen}" alt="${titulo}">
        <h3><i class="fa-solid fa-train"></i> ${titulo}</h3>
        <div class="datos-tecnicos">
            <span><i class="fa-regular fa-calendar-days"></i> ${año}</span>
            <span><i class="fa-solid fa-industry"></i> ${fabricante}</span>
            <span><i class="fa-solid fa-link"></i> ${composicion}</span>
        </div>
        <hr class="separador">
        <p><i class="fa-solid fa-circle-info"></i> ${texto}</p>
    `;
    contenedor.appendChild(caja);
}

// Para que al escribir busque el titulo del tren
function filtrarTarjetas() {
    const textoBuscado = document.getElementById('buscador').value.toLowerCase();
    const tarjetas = document.querySelectorAll('.tarjeta');
    
    for (let i = 0; i < tarjetas.length; i++) {
        const titulo = tarjetas[i].querySelector('h3').textContent.toLowerCase();
        if (titulo.includes(textoBuscado)) {
            tarjetas[i].style.display = 'flex';
        } else {
            tarjetas[i].style.display = 'none';
        }
    }
}

// Para cambiar el color al modo oscuro, claro o personalizado
function aplicarTemaElegido() {
    const seleccion = document.getElementById('selectorTema').value;
    
    if (seleccion === 'claro') {
        document.body.className = 'tema-claro';
        borrarColoresPropios();
    } else if (seleccion === 'oscuro') {
        document.body.className = 'tema-oscuro';
        borrarColoresPropios();
    } else if (seleccion === 'personalizado') {
        document.getElementById('modalTema').classList.remove('oculto');
    }
}

// Quitamos los colores que pusimos a mano para volver a los normales (ahora con la variable correcta)
function borrarColoresPropios() {
    document.body.style.removeProperty('--bg-header');
    document.body.style.removeProperty('--bg-main');
    document.body.style.removeProperty('--bg-footer');
    document.body.style.removeProperty('--bg-tarjeta'); 
}

// Abre la paleta solo si esta puesto el modo personalizado
function abrirPanelColores() {
    const seleccion = document.getElementById('selectorTema').value;
    if (seleccion === 'personalizado') {
        document.getElementById('modalTema').classList.remove('oculto');
    } else {
        alert("Selecciona la opción 'Personalizado' en el menú desplegable para usar la paleta.");
    }
}

// Botones para abrir y cerrar las ventanas de encima y aplicar colores
function prepararBotonesModal() {
    const ventanaAñadir = document.getElementById('modalAñadir');
    const ventanaTema = document.getElementById('modalTema');

    document.getElementById('btnAbrirAñadir').addEventListener('click', () => {
        ventanaAñadir.classList.remove('oculto');
    });

    document.getElementById('btnCerrarAñadir').addEventListener('click', () => {
        ventanaAñadir.classList.add('oculto');
    });

    document.getElementById('btnCerrarTema').addEventListener('click', () => {
        ventanaTema.classList.add('oculto');
    });

    // Aqui recogemos el color de la tarjeta y lo aplicamos
    document.getElementById('btnAplicarTema').addEventListener('click', () => {
        const colorCima = document.getElementById('colorHeader').value;
        const colorMedio = document.getElementById('colorMain').value;
        const colorFondo = document.getElementById('colorFooter').value;
        const colorTarjeta = document.getElementById('colorTarjeta').value;
        
        document.body.style.setProperty('--bg-header', colorCima);
        document.body.style.setProperty('--bg-main', colorMedio);
        document.body.style.setProperty('--bg-footer', colorFondo);
        document.body.style.setProperty('--bg-tarjeta', colorTarjeta); 
        
        ventanaTema.classList.add('oculto');
    });
}

// Cogemos los datos del formulario y metemos la foto para crear el tren
function guardarNuevaTarjeta(evento) {
    evento.preventDefault();
    const titulo = document.getElementById('inputTitulo').value;
    const año = document.getElementById('inputAño').value;
    const fabricante = document.getElementById('inputFabricante').value;
    const composicion = document.getElementById('inputComposicion').value;
    const texto = document.getElementById('inputTexto').value;
    const archivo = document.getElementById('inputImagen').files[0];

    if (archivo) {
        let lector = new FileReader();
        lector.onload = function(e) {
            crearElementoTarjeta(titulo, e.target.result, año, fabricante, composicion, texto);
            
            document.getElementById('modalAñadir').classList.add('oculto');
            document.getElementById('formularioAñadir').reset();
        };
        lector.readAsDataURL(archivo);
    }
}