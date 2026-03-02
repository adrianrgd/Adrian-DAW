//Funcion para crear un lienzo de fondo animado
(function () {
  const lienzo = document.getElementById("lienzo-fondo");
  if (!lienzo) return;
  const contexto = lienzo.getContext("2d");
  let ancho, alto, particulas;
  const PALETA = ["#6688ff", "#ffb9dbff", "#4ddd72", "#ffc85a", "#a78bfa"];

  function redimensionar() {
    ancho = lienzo.width = window.innerWidth;
    alto = lienzo.height = window.innerHeight;
    particulas = Array.from(
      { length: Math.round((ancho * alto) / 6000) },
      () => ({
        x: Math.random() * ancho,
        y: Math.random() * alto,
        r: Math.random() * 2.1 + 1.2,
        vx: (Math.random() - 0.7) * 0.1,
        vy: (Math.random() - 0.7) * 0.1,
        c: PALETA[Math.floor(Math.random() * PALETA.length)],
        a: Math.random() * 0.3 + 0.2,
      }),
    );
  }

  function actualizar() {
    contexto.clearRect(0, 0, ancho, alto);
    for (const p of particulas) {
      contexto.beginPath();
      contexto.arc(p.x, p.y, p.r, 0, Math.PI * 2); 
      contexto.fillStyle = p.c;
      contexto.globalAlpha = p.a;
      contexto.fill();
      p.x += p.vx;
      p.y += p.vy;
      if (p.x < 0) p.x = ancho;
      if (p.x > ancho) p.x = 0;
      if (p.y < 0) p.y = alto;
      if (p.y > alto) p.y = 0;
    }
    contexto.globalAlpha = 1;
    requestAnimationFrame(actualizar);
  }

  redimensionar();
  window.addEventListener("resize", redimensionar);
  actualizar();
})();

// EJERCICIO 6
const input = document.getElementById("buscar");
const select = document.getElementById("filtro-genero");
const botonCargar = document.getElementById("cargar");
const botonLimpiar = document.getElementById("limpiar");
const estadisticas = document.getElementById("estadisticas");
const catalogo = document.getElementById("catalogo");

let datosVideojuegos = [];

botonCargar.addEventListener("click", function () {
  fetch("data.xml")
    .then((response) => response.text())
    .then((data) => {
      const parser = new DOMParser();
      const xml = parser.parseFromString(data, "text/xml");
      const nodos = xml.querySelectorAll("videojuego");

      datosVideojuegos = [];

      nodos.forEach(n => {
        datosVideojuegos.push({
          id: n.getAttribute("id"),
          titulo: n.getElementsByTagName("titulo")[0].textContent,
          estudio: n.getElementsByTagName("estudio")[0].textContent,
          lanzamiento: n.getElementsByTagName("lanzamiento")[0].textContent,
          genero: n.getElementsByTagName("genero")[0].textContent,
          plataforma: n.getElementsByTagName("plataforma")[0].textContent,
          precio: n.getElementsByTagName("precio")[0].textContent,
          valoracion: n.getElementsByTagName("valoracion")[0].textContent
        });
      });

      llenarSelect(datosVideojuegos);
      mostrarDatos(datosVideojuegos);
      mostrarEstadisticas(datosVideojuegos);
    })
    .catch(err => console.error("Error al cargar:", err));
});

function llenarSelect(lista) {
  let generos = ["todos"];
  select.innerHTML = '<option value="todos">Todos los géneros</option>';
  lista.forEach(v => {
    if (!generos.includes(v.genero)) {
      generos.push(v.genero);
      select.innerHTML += `<option value="${v.genero}">${v.genero}</option>`;
    }
  });
}

function mostrarDatos(lista) {
  catalogo.innerHTML = "";
  
  if (lista.length === 0) {
    catalogo.innerHTML = "<p>No se encontraron resultados</p>";
    return;
  }

  lista.forEach(v => {
    catalogo.innerHTML += `
      <div class="videojuego">
        <h2>${v.titulo}</h2>
        <div class="info">
          <p><strong>Estudio:</strong> ${v.estudio}</p>
          <p><strong>Lanzamiento:</strong> ${v.lanzamiento}</p>
          <p><strong>Género:</strong> ${v.genero}</p>
          <p><strong>Precio:</strong> ${v.precio}€</p>
          <p><strong>Valoración:</strong> ${v.valoracion}/100</p>
        </div>
      </div>`;
  });
}

function mostrarEstadisticas(lista) {
  if (lista.length === 0) {
    estadisticas.style.display = "none";
    return;
  }
  
  estadisticas.style.display = "flex";
  const total = lista.length;
  const suma = lista.reduce((s, v) => s + parseFloat(v.valoracion), 0);
  const media = (suma / total).toFixed(1);

  estadisticas.innerHTML = `
      <p><strong>Total juegos:</strong> ${total}</p>
      <p><strong>Nota Media:</strong> ${media}/100</p>
  `;
}

function filtrar() {
  const texto = input.value.toLowerCase();
  const gen = select.value;
  const filtrados = datosVideojuegos.filter(v => 
    v.titulo.toLowerCase().includes(texto) && (gen === "todos" || v.genero === gen)
  );
  mostrarDatos(filtrados);
  mostrarEstadisticas(filtrados);
}

input.addEventListener("input", filtrar);
select.addEventListener("change", filtrar);
botonLimpiar.addEventListener("click", () => {
    input.value = "";
    select.value = "todos";
    mostrarDatos(datosVideojuegos);
    mostrarEstadisticas(datosVideojuegos);
});