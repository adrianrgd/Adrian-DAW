class CentroEducativo {
    String nombre;
    private int ocupacion;
    int planta;
    
    public CentroEducativo(String nombre, int ocupacion, int planta) {
        this.nombre = nombre;
        this.ocupacion = 0;
        this.planta = planta;
    }
    
    //actualizar ocupacion aula
    public void actualizarOcupacion(int ocupacion) {
        this.ocupacion = ocupacion;
        System.out.println("Ocupacion actualizada: " + ocupacion);
        //se valida que sea positivo el valor
        if (ocupacion < 0) {
            System.out.println("Error: La ocupacion no puede ser negativa.");
        }
    }

    
}    

