import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

// Es imprescindible poner la siguiente etiqueta:
@XmlRootElement
public class Persona {
    private int edad;
    private String nombre;
    List<String> hobbies = new ArrayList<>();
    List<Persona> hijos = new ArrayList<>();

    // Si no añadimos lo siguiente nos saltará el error: Persona no tiene un constructor por defecto sin argumentos.
    public Persona() {

    }

    public Persona(int edad, String nombre, List<String> hobbies, List<Persona> hijos) {
        this.edad = edad;
        this.nombre = nombre;
        this.hobbies = hobbies;
        this.hijos = hijos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Persona> getHijos() {
        return hijos;
    }

    public void setHijos(List<Persona> hijos) {
        this.hijos = hijos;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", hobbies=" + hobbies +
                ", hijos=" + hijos +
                '}';
    }
}
