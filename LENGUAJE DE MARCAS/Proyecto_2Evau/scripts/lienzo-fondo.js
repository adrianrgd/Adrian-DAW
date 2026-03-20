(function () {
  const lienzo = document.getElementById("lienzo-fondo");
  if (!lienzo) return; // Si no encuentra el lienzo, no hace nada

  const pincel = lienzo.getContext("2d");
  let ancho, alto, listaDeParticulas; 
  const COLORES = ["#6688ff", "#ffb9dbff", "#4ddd72", "#ffc85a", "#a78bfa"];

  // Adapta el lienzo al tamaño de tu ventana
  function ajustarPantalla() {
    ancho = lienzo.width = window.innerWidth;
    alto = lienzo.height = window.innerHeight;

    // Calculamos cuántos puntos crear según el tamaño de la pantalla
    const cantidad = Math.round((ancho * alto) / 6000);
    
    listaDeParticulas = Array.from({ length: cantidad }, () => ({
      x: Math.random() * ancho,      // Posición horizontal inicial
      y: Math.random() * alto,       // Posición vertical inicial
      radio: Math.random() * 2 + 1,  // Tamaño del punto
      velX: (Math.random() - 0.5) * 0.2, // Velocidad hacia los lados
      velY: (Math.random() - 0.5) * 0.2, // Velocidad hacia arriba/abajo
      color: COLORES[Math.floor(Math.random() * COLORES.length)],
      opacidad: Math.random() * 0.3 + 0.2
    }));
  }

  // Mueve los puntos y los dibuja una y otra vez
  function animar() {
    pincel.clearRect(0, 0, ancho, alto); // Borra el cuadro anterior para "limpiar" el rastro

    for (const p of listaDeParticulas) {
      // Dibujar el punto
      pincel.beginPath();
      pincel.arc(p.x, p.y, p.radio, 0, Math.PI * 2);
      pincel.fillStyle = p.color;
      pincel.globalAlpha = p.opacidad;
      pincel.fill();

      // Mover el punto para el siguiente cuadro
      p.x += p.velX;
      p.y += p.velY;

      // Si el punto se sale por un lado, aparece por el lado opuesto (efecto bucle)
      if (p.x < 0) p.x = ancho;
      if (p.x > ancho) p.x = 0;
      if (p.y < 0) p.y = alto;
      if (p.y > alto) p.y = 0;
    }

    pincel.globalAlpha = 1;
    requestAnimationFrame(animar); // Llama a esta función de nuevo lo más rápido posible
  }

  // 3. INICIO: Ejecuta todo al cargar y si cambias el tamaño de la ventana
  ajustarPantalla();
  window.addEventListener("resize", ajustarPantalla);
  animar();
})();