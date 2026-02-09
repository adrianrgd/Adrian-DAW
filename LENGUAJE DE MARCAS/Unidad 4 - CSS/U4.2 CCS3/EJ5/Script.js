const cargar = document.getElementById("cargar");
const lista = document.getElementById("lista");

function cargarDatos() {
  fetch("data.xml")
    .then((response) => response.text())
    .then((data) => {
      const parser = new DOMParser();
      const xml = parser.parseFromString(data, "application/xml");
      const productos = xml.getElementsByTagName("producto");

      for (let i = 0; i < productos.length; i++) {
        const nombre =
          productos[i].getElementsByTagName("nombre")[0].textContent;
        const precio =
          productos[i].getElementsByTagName("precio")[0].textContent;

        lista.innerHTML += `
        <li>
            <p>Nombre: ${nombre} - Precio: ${precio} €</p>
        </li>
        `;
      }
    });
}
cargar.addEventListener("click", cargarDatos);
