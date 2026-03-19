document.addEventListener('DOMContentLoaded', () => {
    cargarTarjetasDesdeXML();
});

async function cargarTarjetasDesdeXML() {
    const contenedor = document.querySelector('.contenedor');
    
    try {
        // Petición al archivo XML proporcionado
        const respuesta = await fetch('data/tarjetas.xml');
        if (!respuesta.ok) throw new Error("Error al cargar el archivo XML");
        
        const datosTexto = await respuesta.text();
        const parser = new DOMParser();
        const xmlDoc = parser.parseFromString(datosTexto, "text/xml");
        
        // Seleccionamos todas las etiquetas <tarjeta> del XML
        const tarjetas = xmlDoc.querySelectorAll('tarjeta');

        // Limpiamos el contenedor antes de insertar los datos
        contenedor.innerHTML = '';

        tarjetas.forEach(t => {
            // Extracción de datos usando tus etiquetas exactas
            const nombre = t.querySelector('Nombre').textContent; //
            const imagen = t.querySelector('imagen').textContent; //
            const texto = t.querySelector('texto').textContent;   //

            // Creamos la estructura visual de la ventana de PC
            const tarjetaHTML = `
                <div class="tarjeta">
                    <div class="barra-titulo">
                        <div class="icono-titulo">📁</div>
                        <div class="texto-titulo">SISTEMA_LOCAL/${nombre.toUpperCase()}.EXE</div>
                        <div class="botones-titulo">
                            <div class="bt">_</div>
                            <div class="bt">□</div>
                            <div class="bt">×</div>
                        </div>
                    </div>
                    
                    <section class="seccionImagen">
                        <img src="${imagen}" alt="${nombre}">
                    </section>
                    
                    <section class="seccionContenido">
                        <h2 id="tituloTarjeta">${nombre}</h2>
                        <hr class="linea">
                        <p id="textoTarjeta">${texto}</p>
                    </section>

                    <div class="barra-estado">
                        <div class="punto"></div>
                        <span>PROCESANDO_DATOS_XML: OK</span>
                    </div>
                </div>
            `;
            
            contenedor.innerHTML += tarjetaHTML;
        });

    } catch (error) {
        console.error("Fallo en la carga:", error);
        contenedor.innerHTML = `<p style="color: #ff6eb4; font-family: monospace;">ERROR_DEL_SISTEMA: No se pudo leer tarjetas.xml</p>`;
    }
}
