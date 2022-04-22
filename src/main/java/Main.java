import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creamos un objeto que va a ser exportado a un fichero XML
        // creamos primero las listas y luego el objeto
        List<String> h = new ArrayList<>();
        h.add("Leer");
        h.add("Calistenia");
        h.add("Hacer el vago");

        List<Persona> hi = new ArrayList<>();
        hi.add(new Persona(3, "Jaimito", null, null));
        hi.add(new Persona(3, "Jorgito", null, null));
        hi.add(new Persona(3, "Juanito", null, null));

        Persona p = new Persona(30, "Pato Donald", h, hi);

        // Necesitamos, además del objeto, ubicarle el fichero, decirle dónde se va a crear y cómo se va a llamar
        String ruta = "src\\Donald.xml";
        File f = new File(ruta);

        // Ahora añadimos las líneas necesarias para JAXB --> siempre igual, sólo cambiamos el nombre de la clase
        try {
            JAXBContext contexto = JAXBContext.newInstance(Persona.class);
            Marshaller m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Llamamos al método marshal con el objeto y el fichero que tenemos ya preparados
            m.marshal(p, f); // -> se crea el fichero


            // Ahora vamos a hacerlo al revés: tenemos el fichero Pasameajaval.xml y queremos parsearlo a un objeto java
            Unmarshaller um = contexto.createUnmarshaller();

            // Y de ahí lo guardamos en una variable tipo Persona, para poder después referenciarla: imprimir datos, etc.
            Persona p2 = (Persona) um.unmarshal(new File("src\\Pasameajava.xml"));
            System.out.println(p2.toString());

        } catch (JAXBException e) {

            e.printStackTrace();
        }
    }
}
